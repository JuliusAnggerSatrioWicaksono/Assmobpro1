package org.d3if3148.assesmentmobpro.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3148.assesmentmobpro.db.CodDao
import org.d3if3148.assesmentmobpro.db.CodEntity
import org.d3if3148.assesmentmobpro.model.HasilHitung
import org.d3if3148.assesmentmobpro.model.hitungCod

class HitungViewModel(private val db: CodDao) : ViewModel() {
    private val hasilHitung = MutableLiveData<HasilHitung?>()

    fun konversiRupiah(uang: Float) {
        val dataCod = CodEntity(
            uang = uang
        )
        hasilHitung.value = dataCod.hitungCod()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataCod)
            }
        }
    }

    fun getHasilCod(): LiveData<HasilHitung?> = hasilHitung
}