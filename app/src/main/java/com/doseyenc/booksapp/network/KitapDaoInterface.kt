package com.doseyenc.booksapp.network

import com.doseyenc.booksapp.response.KitaplarResponse
import retrofit2.Call
import retrofit2.http.GET

interface KitapDaoInterface {

    @GET("all_books.php")
    fun kitaplariAl() : Call<KitaplarResponse>
}