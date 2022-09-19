package androidx.cap.app.curielappv2.ui.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cap.app.curielappv2.R
import androidx.cap.app.curielappv2.model.data.Articolo
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListAdapter(private val onClickListener: OnClickListener<Articolo>) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private  var dataSet= emptyList<Articolo>()


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeView: TextView = view.findViewById(R.id.nomeArticolo)
        val idView: TextView = view.findViewById(R.id.idArticolo)
        val buttonDelete: FloatingActionButton = view.findViewById(R.id.deleteItemButton)


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_articolo, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.idView.text=dataSet[position].id.toString()
        viewHolder.nomeView.text = dataSet[position].nome
        viewHolder.buttonDelete.setOnClickListener {
            onClickListener.onClick(dataSet[position])
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun setData(articoli: List<Articolo>){
        this.dataSet= articoli
        notifyDataSetChanged()
    }



}