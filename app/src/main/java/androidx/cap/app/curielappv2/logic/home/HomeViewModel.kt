package androidx.cap.app.curielappv2.logic.home


import android.app.Application
import androidx.cap.app.curielappv2.model.CurielDatabase
import androidx.cap.app.curielappv2.model.data.Utente
import androidx.lifecycle.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeViewModel(application: Application) : AndroidViewModel(application) {


    private val utentiDao= CurielDatabase.getDatabase(application).utentiDao()


     /*val debitoElena: LiveData<Double> = utentiDao.getImportoUtente("Elena")


     val debitoMichele:LiveData<Double> = utentiDao.getImportoUtente("Michele")*/

    private val utenti= utentiDao.getAll()

    fun getUser():LiveData<List<Utente>>{
        return utenti
    }


}


