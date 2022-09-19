package androidx.cap.app.curielappv2.model

import android.content.Context
import androidx.cap.app.curielappv2.model.dao.ListaDao
import androidx.cap.app.curielappv2.model.dao.StoricoDao
import androidx.cap.app.curielappv2.model.dao.UtentiDao
import androidx.cap.app.curielappv2.model.data.Articolo
import androidx.cap.app.curielappv2.model.data.Spesa
import androidx.cap.app.curielappv2.model.data.Utente
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Articolo::class, Spesa::class,Utente::class], version = 3, exportSchema = false)
abstract class CurielDatabase : RoomDatabase() {
    abstract fun storicoDao() : StoricoDao
    abstract fun listaDao() : ListaDao
    abstract fun utentiDao() : UtentiDao

    companion object{

        @Volatile
        private var INSTANCE : CurielDatabase? = null

        fun getDatabase(context: Context): CurielDatabase{

            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CurielDatabase::class.java,
                    "curiel_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }

        }

    }
}