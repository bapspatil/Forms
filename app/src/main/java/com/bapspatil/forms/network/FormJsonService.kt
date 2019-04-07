package com.bapspatil.forms.network

import com.bapspatil.forms.model.FormModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/*
** Created by Bapusaheb Patil {@link https://bapspatil.com}
*/

interface FormJsonService {

    @GET("/dynamic_form.json")
    fun getForm(): Call<FormModel>

    companion object {
        val BASE_URL = "https://raw.githubusercontent.com/bapspatil/Forms/master/assets"

        fun create(): FormJsonService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(FormJsonService::class.java)
        }
    }
}