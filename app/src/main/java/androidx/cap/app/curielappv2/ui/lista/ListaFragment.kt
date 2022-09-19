package androidx.cap.app.curielappv2.ui.lista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cap.app.curielappv2.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.cap.app.curielappv2.databinding.FragmentListaBinding
import androidx.cap.app.curielappv2.logic.lista.ListaViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null


    private val binding get() = _binding!!
    private lateinit var listaViewModel: ListaViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listaViewModel = ViewModelProvider(this).get(ListaViewModel::class.java)

        _binding = FragmentListaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.floatingActionButton.setOnClickListener {

            findNavController().navigate(R.id.action_navigation_lista_to_addArticoloFragment)

        }

        binding.deleteAllfloatingActionButton.setOnClickListener{
            listaViewModel.deleteAll()
        }

        val listaArticoliView: RecyclerView = binding.listView
        val adapter=ListAdapter(OnClickListener{
            listaViewModel.delete(it)
        })
        listaArticoliView.adapter=adapter
        listaArticoliView.layoutManager=LinearLayoutManager(requireContext())


        listaViewModel.listaArticoli.observe(viewLifecycleOwner) {
            adapter.setData(it)

        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}