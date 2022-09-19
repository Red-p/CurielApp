package androidx.cap.app.curielappv2.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "utenti_table")
data class Utente(
    @PrimaryKey val nome :String,
    @ColumnInfo(name = "importo")val ammontareSpeso : Double
    )