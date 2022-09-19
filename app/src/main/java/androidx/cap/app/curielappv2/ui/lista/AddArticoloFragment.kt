package androidx.cap.app.curielappv2.ui.lista


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cap.app.curielappv2.R
import androidx.cap.app.curielappv2.databinding.AddArticoloFragmentBinding
import androidx.cap.app.curielappv2.logic.lista.AddArticoloViewModel
import androidx.cap.app.curielappv2.model.data.Articolo
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class AddArticoloFragment : Fragment() {



    private lateinit var addArticoloViewModel: AddArticoloViewModel
    private var _binding : AddArticoloFragmentBinding?=null

    private val binding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= AddArticoloFragmentBinding.inflate(inflater, container, false)

        addArticoloViewModel = ViewModelProvider(this).get(AddArticoloViewModel::class.java)

        binding.confermaArticoli.setOnClickListener {
            println("sono nella add articolo")
            writeDB(binding.listaArticoliText.text.toString())
        }

        return binding.root
    }


      fun writeDB(listaArticoli: String){
        val listaAsString= listaArticoli.split("\n")

        listaAsString.iterator().forEach {
            if(it.isNotBlank())
                addArticoloViewModel.addArticolo(Articolo(0, it.trim()))

        }
        findNavController().navigate(R.id.action_addArticoloFragment_to_navigation_lista)

    }





}