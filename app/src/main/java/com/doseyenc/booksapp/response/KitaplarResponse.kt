package com.doseyenc.booksapp.response

import com.doseyenc.booksapp.model.kitap
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KitaplarResponse(
    @SerializedName("books") @Expose var books:List<kitap>,
    @SerializedName("success") @Expose var success:Int
)
