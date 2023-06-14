package org.d3if3148.assesmentmobpro.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CodEntity::class], version = 1, exportSchema = false)
abstract class CodDb : RoomDatabase() {
    abstract val dao: CodDao
    companion object {
        @Volatile
        private var INSTANCE: CodDb? = null

        fun getInstance(context: Context): CodDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    CodDb::class.java,
                    "cod.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }
                return instance
            }
        }
    }
}