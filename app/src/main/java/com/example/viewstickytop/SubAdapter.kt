package com.example.viewstickytop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewstickytop.databinding.MainItemBinding
import com.example.viewstickytop.databinding.SubItemBinding

class SubAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            SubItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(position)
    }

    override fun getItemCount(): Int = 10

    inner class ViewHolder(private val binding: SubItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(index: Int) {
            binding.apply {
                this.index = index
            }
        }
    }
}