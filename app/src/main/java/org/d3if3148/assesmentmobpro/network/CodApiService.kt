package org.d3if3148.assesmentmobpro.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3148.assesmentmobpro.data.DataCod
import org.d3if3148.assesmentmobpro.model.HasilHitung
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://raw.githubusercontent.com/" +
            "JuliusAnggerSatrioWicaksono/static-api/main/static-api/"

//https://raw.githubusercontent.com/JuliusAnggerSatrioWicaksono/Assmobpro1/static-api/static-api.json

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CodApiService {
    @GET("static-api.json")
    suspend fun getCod(): List<DataCod>
}

object CodApi {
    val service: CodApiService by lazy {
        retrofit.create(CodApiService::class.java)
    }

    fun getCodUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"
    }

    enum class ApiStatus { LOADING, SUCCESS, FAILED }
}