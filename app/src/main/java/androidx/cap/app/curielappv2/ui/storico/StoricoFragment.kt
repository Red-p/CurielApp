package androidx.cap.app.curielappv2.ui.storico

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import androidx.cap.app.curielappv2.databinding.FragmentStoricoBinding
import androidx.cap.app.curielappv2.logic.storico.StoricoViewModel
import androidx.cap.app.curielappv2.ui.lista.OnClickListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StoricoFragment : Fragment() {

    private var _binding: FragmentStoricoBinding? = null
    private lateinit  var storicoViewModel : StoricoViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        storicoViewModel = ViewModelProvider(this).get(StoricoViewModel::class.java)
        _binding = FragmentStoricoBinding.inflate(inflater, container, false)


        val adapterStorico=StoricoAdapter(OnClickListener {
            storicoViewModel.delete(it)
        })
        val listaSpeseView: RecyclerView = binding.listaSpeseView
        listaSpeseView.adapter=adapterStorico
        listaSpeseView.layoutManager= LinearLayoutManager(requireContext())

        storicoViewModel.listaSpese.observe(viewLifecycleOwner){
            adapterStorico.setData(it)


        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}