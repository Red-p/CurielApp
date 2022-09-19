package androidx.cap.app.curielappv2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cap.app.curielappv2.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.cap.app.curielappv2.databinding.FragmentHomeBinding
import androidx.cap.app.curielappv2.logic.home.HomeViewModel
import androidx.cap.app.curielappv2.model.data.Utente
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeViewModel : HomeViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val buttonAddSpesa= binding.addSpesaButton

        buttonAddSpesa.setOnClickListener {

            findNavController().navigate(R.id.action_navigation_home_to_addSpesaFragment)
        }

       /* val debitoTextViewElena: TextView = binding.debitoViewElena
        val debitoTextViewMichele: TextView = binding.debitoViewMichele*/
        homeViewModel.getUser().observe(viewLifecycleOwner){

            displayData(it)


        }
    }

    private fun displayData(it: List<Utente>?) {
        var debitoM=0.0
        var debitoE=0.0
        if(it!![0].ammontareSpeso> it[1].ammontareSpeso){
            debitoM= it!![0].ammontareSpeso - it[1].ammontareSpeso
        }else if(it!![0].ammontareSpeso < it[1].ammontareSpeso){
            debitoE= it!![1].ammontareSpeso - it[0].ammontareSpeso
        }

        binding.debitoViewElena.text= formatData(debitoE)
        binding.debitoViewMichele.text= formatData(debitoM)


    }
    private fun formatData(debitoToShow: Double):String{
        return ((debitoToShow * 100.0).roundToInt() / 100.0).toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}