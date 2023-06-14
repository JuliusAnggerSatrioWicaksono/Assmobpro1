package org.d3if3148.assesmentmobpro.model

import org.d3if3148.assesmentmobpro.db.CodEntity

fun CodEntity.hitungCod(): HasilHitung {
    val hasil = uang / 14978

    return HasilHitung(hasil)
}