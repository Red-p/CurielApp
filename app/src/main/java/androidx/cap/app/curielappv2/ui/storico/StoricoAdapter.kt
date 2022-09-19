package androidx.cap.app.curielappv2.ui.storico

import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cap.app.curielappv2.R
import androidx.cap.app.curielappv2.model.data.Spesa
import androidx.cap.app.curielappv2.ui.lista.OnClickListener
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StoricoAdapter(private val onClickListener: OnClickListener<Spesa>): RecyclerView.Adapter<StoricoAdapter.StoricoViewHolder>() {

    private  var dataStorico= emptyList<Spesa>()

    class StoricoViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val textTag: TextView =view.findViewById(R.id.TagUtenteText)
        val importoSpesoText :TextView =view.findViewById(R.id.importoSpesoText)
        val dataText :TextView =view.findViewById(R.id.dataSpesa)
        val tipoSpesaText :TextView =view.findViewById(R.id.tipoSpesa)
        val deleteButton: FloatingActionButton=view.findViewById(R.id.deleteStoricoItemButton)



    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): StoricoViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.row_storico, viewGroup, false)

        return StoricoViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoricoViewHolder, position: Int) {
       val currentSpesa=dataStorico[position]
        holder.dataText.text=currentSpesa.data
        holder.importoSpesoText.text=currentSpesa.importoSpeso.toString()
        holder.textTag.text=currentSpesa.utentePagante.subSequence(0,1).toString()
        holder.tipoSpesaText.text=currentSpesa.tipo
        holder.deleteButton.setOnClickListener {
            onClickListener.onClick(currentSpesa)
        }
    }

    override fun getItemCount(): Int {
        return this.dataStorico.size
    }

    fun setData(spese : List<Spesa>){
        this.dataStorico=spese
        notifyDataSetChanged()
    }
}