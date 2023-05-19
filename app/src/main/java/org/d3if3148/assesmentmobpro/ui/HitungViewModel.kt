package org.d3if3148.assesmentmobpro.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3148.assesmentmobpro.model.HasilHitung

class HitungViewModel : ViewModel() {
    private val hasilHitung1 = MutableLiveData<HasilHitung>()
    private val hasilHitung2 = MutableLiveData<HasilHitung>()

    fun konversiRupiah(input : Float){
        val hasil1 = input / 14978
        hasilHitung1.value = HasilHitung(hasil1)
    }

    fun konversiDollar(input: Float){
        val hasil2 = input * 14978
        hasilHitung2.value = HasilHitung(hasil2)
    }

    fun getHasilCod1(): LiveData<HasilHitung?> = hasilHitung1
    fun getHasilCod2(): LiveData<HasilHitung?> = hasilHitung2
}