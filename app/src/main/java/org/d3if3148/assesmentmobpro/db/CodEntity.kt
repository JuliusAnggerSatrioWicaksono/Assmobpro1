package org.d3if3148.assesmentmobpro.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cod") data class CodEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var hasil: Float
)