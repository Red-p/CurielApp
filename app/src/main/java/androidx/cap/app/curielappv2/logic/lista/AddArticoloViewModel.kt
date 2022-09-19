package androidx.cap.app.curielappv2.logic.lista

import android.app.Application
import androidx.cap.app.curielappv2.model.CurielDatabase
import androidx.cap.app.curielappv2.model.dao.ListaDao
import androidx.cap.app.curielappv2.model.data.Articolo
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddArticoloViewModel(application: Application) : AndroidViewModel(application) {

    private val listaDao: ListaDao = CurielDatabase.getDatabase(application).listaDao()



    fun addArticolo(articolo: Articolo) {
        GlobalScope.launch(Dispatchers.IO) {
            listaDao.insert(articolo)
        }
    }
}