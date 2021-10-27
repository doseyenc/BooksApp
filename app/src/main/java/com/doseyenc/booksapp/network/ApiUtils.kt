package com.doseyenc.booksapp.network

class ApiUtils {
    companion object{

        private const val BASE_URL="http://books.canerture.com/"

        fun kitalarDAOInterfaceGetir():KitapDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(KitapDaoInterface::class.java)
        }
    }
}