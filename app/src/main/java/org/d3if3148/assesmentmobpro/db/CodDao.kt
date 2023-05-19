package org.d3if3148.assesmentmobpro.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CodDao {
    @Insert
    fun insert(cod: CodEntity)

    @Query("SELECT * FROM cod ORDER BY id DESC LIMIT 1")
    fun getLastCod(): LiveData<CodEntity?>
}