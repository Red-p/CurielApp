package androidx.cap.app.curielappv2.model.dao

import androidx.cap.app.curielappv2.model.data.Articolo
import androidx.cap.app.curielappv2.model.data.Spesa
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface ListaDao {
    @Query("SELECT * FROM listarticoli_table")
    fun getAll(): LiveData<List<Articolo>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(articolo: Articolo)

    @Delete
    suspend fun delete(articolo: Articolo)

    @Query("DELETE FROM listarticoli_table")
    suspend fun deleteAll()
}