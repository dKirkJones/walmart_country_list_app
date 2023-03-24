package com.djmakesapps.countrylist.network

import com.djmakesapps.countrylist.utils.SimpleResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkLayer {

    const val BASE_URL = "https://gist.githubusercontent.com/"

    private val interceptor = HttpLoggingInterceptor().apply {
        level = (HttpLoggingInterceptor.Level.BODY)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor).build()

    val api: CountryApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CountryApi::class.java)

}

inline fun <T> safeApiCall(apiCall: ()-> Response<T>): SimpleResponse<T> {
    return try {
        // If a network request is to fail this is where it would fail
        SimpleResponse.success(apiCall.invoke())
    } catch (e: Exception){
        // This when we would call our SimpleResponse object
        SimpleResponse.failure(e)
    }
}