package androidx.cap.app.curielappv2.logic.home

import android.app.Application

import androidx.cap.app.curielappv2.model.CurielDatabase
import androidx.cap.app.curielappv2.model.data.Spesa
import androidx.cap.app.curielappv2.model.data.Utente
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class AddSpesaViewModel(application: Application) : AndroidViewModel(application) {
    private val storicoDao=CurielDatabase.getDatabase(application).storicoDao()
    private val utentiDao=CurielDatabase.getDatabase(application).utentiDao()

    fun addSpesa(spesa: Spesa) {

        GlobalScope.launch(Dispatchers.IO) {
            updateDebito(spesa)
            storicoDao.insert(spesa)

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
        val user = Utente(nome = utenteIndebitato, ammontareSpeso = toAdd)
        updateUtente(user)
    }



    fun updateUtente(utente: Utente){
        GlobalScope.launch(Dispatchers.IO){
            utentiDao.updateUtente(utente.nome,utente.ammontareSpeso)
        }
    }


}