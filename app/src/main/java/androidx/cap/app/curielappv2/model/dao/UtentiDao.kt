package androidx.cap.app.curielappv2.model.dao


import androidx.cap.app.curielappv2.model.data.Utente
import androidx.lifecycle.LiveData

import androidx.room.Dao
import androidx.room.Query

import kotlinx.coroutines.flow.Flow

@Dao
interface UtentiDao {

    @Query("SELECT * FROM utenti_table")
    fun getAll(): LiveData<List<Utente>>

    @Query("SELECT importo FROM utenti_table AS ut WHERE ut.nome= :utente")
    fun getImportoUtente(utente: String): LiveData<Double>

    @Query("UPDATE utenti_table SET importo= importo + :debito WHERE nome= :nomeUtente ")
    suspend fun updateUtente(nomeUtente : String, debito :Double)

}