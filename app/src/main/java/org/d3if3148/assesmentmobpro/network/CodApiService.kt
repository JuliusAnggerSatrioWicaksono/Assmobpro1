package org.d3if3148.assesmentmobpro.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3148.assesmentmobpro.model.HasilHitung
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://raw.githubusercontent.com/" + "indraazimi/galeri-hewan/static-api/"

private val moshi = Moshi.Builder() .add(KotlinJsonAdapterFactory()) .build()


private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface CodApiService {
    @GET("static-api.json")
    suspend fun getCod(): List<HasilHitung>
}

object CodApi {
    val service: CodApiService by lazy {
        retrofit.create(CodApiService::class.java)
    }
}