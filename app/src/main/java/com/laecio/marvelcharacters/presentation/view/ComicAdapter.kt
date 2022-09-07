package com.laecio.marvelcharacters.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.laecio.marvelcharacters.databinding.ComicItemBinding

class ComicAdapter(private val  comicList: ArrayList<String>):
    RecyclerView.Adapter<ComicAdapter.ComicItemViewHolder>()
{
    class ComicItemViewHolder(private val binding: ComicItemBinding):
            RecyclerView.ViewHolder(binding.root) {
                fun  bind(comicName: String){
                    binding.comicTitle.text = comicName
                }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicItemViewHolder {
        val binding = ComicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ComicItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicItemViewHolder, position: Int) {
        val comicName = comicList[position]
        holder.bind(comicName)
    }

    override fun getItemCount(): Int {
       return comicList.size
    }
}