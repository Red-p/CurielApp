package androidx.cap.app.curielappv2.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.cap.app.curielappv2.R
import androidx.cap.app.curielappv2.databinding.AddSpesaFragmentBinding
import androidx.cap.app.curielappv2.logic.home.AddSpesaViewModel
import androidx.cap.app.curielappv2.miscellaneous.DataConverter
import androidx.cap.app.curielappv2.model.data.Spesa
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import java.time.LocalDate
import java.time.format.DateTimeParseException

class AddSpesaFragment : Fragment() {


    private var _binding : AddSpesaFragmentBinding?=null
    private lateinit var viewModel: AddSpesaViewModel
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= AddSpesaFragmentBinding.inflate(inflater, container, false)
        viewModel=ViewModelProvider(this).get(AddSpesaViewModel::class.java)

        binding.confermaSpesaBtn.setOnClickListener {
            writeDB()
            findNavController().navigate(R.id.action_addSpesaFragment_to_navigation_home)
        }
        return binding.root
    }

    private fun getUtentePagante(): String{
        val radioButtonM=binding.radioButtonMichele
        val radioButtonE=binding.radioButtonElena

        if(!radioButtonE.isChecked and !radioButtonM.isChecked)
            return ""

        return if(radioButtonE.isChecked) "Elena" else "Michele"

    }

    private fun writeDB() {
        val tipoSpesa= binding.editTextTipoSpesa
        val importoSpesa= binding.editTextImportoSpeso
        val dataSpesa= binding.editTextDataSpesa
        var utentePagante=""
        if(tipoSpesa.text.toString().isBlank() or tipoSpesa.text.toString().isEmpty())
            return

        if(importoSpesa.text.toString().isBlank() or importoSpesa.text.toString().isEmpty())
            return

        if(dataSpesa.text.toString().isBlank() or dataSpesa.text.toString().isEmpty())
            return

        if(getUtentePagante().isEmpty())
            return

        utentePagante= getUtentePagante()

        var formattedData: LocalDate?
        try {
             formattedData = DataConverter.stringToDate(dataSpesa.text.toString())
        }catch (e: DateTimeParseException){
            return
        }

       viewModel.addSpesa(Spesa(id= 0,
            utentePagante = utentePagante,
            tipo = tipoSpesa.text.toString(),
            data = formattedData.toString(),
            importoSpeso = importoSpesa.text.toString().toDouble()
        ))



    }


}