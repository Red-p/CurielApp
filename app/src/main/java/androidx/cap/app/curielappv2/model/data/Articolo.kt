package androidx.cap.app.curielappv2.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "listarticoli_table",indices = [Index(value = ["nome"],
    unique = true)])
data class Articolo(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name= "nome")val nome: String)