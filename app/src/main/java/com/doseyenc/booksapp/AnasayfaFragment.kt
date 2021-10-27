package com.doseyenc.booksapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.doseyenc.booksapp.databinding.FragmentAnasayfaBinding
import com.doseyenc.booksapp.model.kitap
import com.doseyenc.booksapp.network.ApiUtils
import com.doseyenc.booksapp.response.KitaplarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    var kitaplarList : ArrayList<kitap> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAnasayfaBinding.inflate(layoutInflater)
        kitaplariGetir()
        return binding.root
    }

    private fun kitaplariGetir(){
        ApiUtils.kitalarDAOInterfaceGetir().kitaplariAl().enqueue(
            object : Callback <KitaplarResponse>{
                override fun onResponse(
                    call: Call<KitaplarResponse>,
                    response: Response<KitaplarResponse>
                ) {
                    val tempList = response.body()?.books
                    tempList?.let {
                        kitaplarList = it as ArrayList<kitap>
                    }
                    val kitaplarAdapter = kitaplarAdapter(kitaplarList)
                    binding.kitapRV.adapter = kitaplarAdapter
                    binding.kitapRV.layoutManager = GridLayoutManager(context,2)
                    binding.kitapRV.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<KitaplarResponse>, t: Throwable) {}

            }
        )
    }
}