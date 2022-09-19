package androidx.cap.app.curielappv2.logic.storico

import android.app.Application
import androidx.cap.app.curielappv2.model.CurielDatabase
import androidx.cap.app.curielappv2.model.data.Articolo
import androidx.cap.app.curielappv2.model.data.Spesa
import androidx.cap.app.curielappv2.model.data.Utente
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class StoricoViewModel(application: Application) : AndroidViewModel(application) {

    val listaSpese: LiveData<List<Spesa>>

    private val storicoDao= CurielDatabase.getDatabase(application).storicoDao()
    private val utentiDao=CurielDatabase.getDatabase(application).utentiDao()


    init {

        this.listaSpese = storicoDao.getAll()

    }

    fun delete(spesa:Spesa){
        GlobalScope.launch(Dispatchers.IO){
            updateDebito(spesa)
            storicoDao.delete(spesa)
        }
    }

    private fun getOtherUser(user:String):String {
        return if(user == "Michele") "Elena" else "Michele"
    }
    fun updateDebito(spesa:Spesa){

        val utentePagante = spesa.utentePagante
        val mezzaSpesa = spesa.importoSpeso / 2
        val toAdd = (mezzaSpesa * 100.0).roundToInt() / 100.0
        val utenteIndebitato = getOtherUser(utentePagante)
        val user = Utente(nome = utenteIndebitato, ammontareSpeso = -toAdd)
        updateUtente(user)
    }



    fun updateUtente(utente: Utente){
        GlobalScope.launch(Dispatchers.IO){
            utentiDao.updateUtente(utente.nome,utente.ammontareSpeso)
        }
    }




}