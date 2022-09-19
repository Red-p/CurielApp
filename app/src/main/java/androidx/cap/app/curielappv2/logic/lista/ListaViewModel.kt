package androidx.cap.app.curielappv2.logic.lista

import android.app.Application
import androidx.cap.app.curielappv2.model.CurielDatabase
import androidx.cap.app.curielappv2.model.data.Articolo
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListaViewModel(application: Application) : AndroidViewModel(application) {

    val listaArticoli: LiveData<List<Articolo>>

    private val listaDao= CurielDatabase.getDatabase(application).listaDao()

    init {

        this.listaArticoli = listaDao.getAll()

    }

    fun deleteAll(){
        GlobalScope.launch(Dispatchers.IO){
            listaDao.deleteAll()

        }

    }

    fun delete(articolo: Articolo){
        GlobalScope.launch(Dispatchers.IO){
            listaDao.delete(articolo)
        }
    }

}