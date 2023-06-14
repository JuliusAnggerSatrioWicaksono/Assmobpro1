package org.d3if3148.assesmentmobpro.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3148.assesmentmobpro.db.CodDao


class HistoriViewModel(private val db: CodDao) : ViewModel() {
    val data = db.getLastCod()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}