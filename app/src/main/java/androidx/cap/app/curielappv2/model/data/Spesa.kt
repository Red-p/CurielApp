package androidx.cap.app.curielappv2.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "storico_table")
data class Spesa(
    @PrimaryKey(autoGenerate = true)  val id:Int,
    @ColumnInfo(name = "importo_speso")val importoSpeso: Double,
    @ColumnInfo(name = "utente_pagante")val utentePagante: String,
    @ColumnInfo(name = "tipo" )val tipo: String,
    @ColumnInfo(name = "data")val data: String
)