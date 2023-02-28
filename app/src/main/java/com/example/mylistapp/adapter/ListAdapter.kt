package com.example.mylistapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylistapp.R
import com.example.mylistapp.databinding.ItemPostBinding
import com.example.mylistapp.model.PhotosModel
import com.squareup.picasso.Picasso

class ListAdapter(private val list: List<PhotosModel>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<ListAdapter.ReasonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReasonViewHolder =
        ReasonViewHolder(ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ReasonViewHolder, position: Int) {
        holder.bind(list[holder.adapterPosition])
    }

    override fun getItemCount(): Int = list.size


    inner class ReasonViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pm: PhotosModel) {
            binding.tvDescription.text = pm.title
            binding.tvTitle.text = pm.id.toString()
            Picasso.get()
                .load(pm.url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.imageView);
            binding.root.setOnClickListener {
                val position = adapterPosition
                onItemSelected(position)
                notifyDataSetChanged()
            }
        }
    }
}