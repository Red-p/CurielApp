package androidx.cap.app.curielappv2.model.dao

import androidx.cap.app.curielappv2.model.data.Spesa
import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface StoricoDao {
    @Query("SELECT * FROM storico_table")
    fun getAll(): LiveData<List<Spesa>>

    @Query("SELECT * FROM storico_table ORDER BY data DESC LIMIT 1")
    fun getLast(): Flow<Spesa>



    @Query("SELECT * FROM storico_table as st WHERE st.utente_pagante = :utentePagante ")
    suspend fun filterbyName(utentePagante: String): List<Spesa>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(spesa: Spesa)

    @Delete
    suspend fun delete(spesa: Spesa)

    @Query("DELETE FROM storico_table")
    suspend fun deleteAll()
}