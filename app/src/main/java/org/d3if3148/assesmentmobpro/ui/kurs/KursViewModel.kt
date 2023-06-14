package org.d3if3148.assesmentmobpro.ui.kurs

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3148.assesmentmobpro.data.DataCod
import org.d3if3148.assesmentmobpro.network.CodApi
import java.util.concurrent.TimeUnit

class KursViewModel : ViewModel() {
    private val data = MutableLiveData<List<DataCod>>()
    private val status = MutableLiveData<CodApi.ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(CodApi.ApiStatus.LOADING)
            try {
                data.postValue(CodApi.service.getCod())
                status.postValue(CodApi.ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(CodApi.ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<DataCod>> = data

    fun getStatus(): LiveData<CodApi.ApiStatus> = status

}