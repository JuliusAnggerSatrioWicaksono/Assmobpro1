package org.d3if3148.assesmentmobpro.ui.hitung

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3148.assesmentmobpro.db.CodDao
import java.lang.IllegalArgumentException

class HitungViewModelFactory (
    private val db: CodDao
    ): ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HitungViewModel::class.java)) {
                return HitungViewModel(db) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
            }
        }