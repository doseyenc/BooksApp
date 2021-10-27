package com.doseyenc.booksapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doseyenc.booksapp.databinding.KitapCardBinding
import com.doseyenc.booksapp.model.kitap
import com.squareup.picasso.Picasso

class kitaplarAdapter(private var kitaplarList: ArrayList<kitap>)
    :RecyclerView.Adapter<kitaplarAdapter.KitapCardDesign>(){

    class KitapCardDesign(val kitapCardBinding: KitapCardBinding)
        :RecyclerView.ViewHolder(kitapCardBinding.root){

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitapCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val kitapCardBinding = KitapCardBinding.inflate(layoutInflater,parent,false)
        return KitapCardDesign(kitapCardBinding)
    }

    override fun onBindViewHolder(holder: KitapCardDesign, position: Int) {
        val kitap = kitaplarList[position]

        holder.kitapCardBinding.apply {
            kitapAdTextView.text=kitap.book_name
            Picasso.get().load(kitap.book_image_url).into(kitapImageView)
        }
    }

    override fun getItemCount()=kitaplarList.size
}