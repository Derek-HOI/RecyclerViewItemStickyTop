package com.example.viewstickytop

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewstickytop.databinding.MainItemBinding

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            MainItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? ViewHolder)?.bind(position)
    }

    override fun getItemCount(): Int = 5

    inner class ViewHolder(private val binding: MainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val adapter: SubAdapter by lazy {
            SubAdapter()
        }

        private val padding10 = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            10.0F,
            binding.root.context.resources.displayMetrics
        )

        fun bind(index: Int) {
            binding.apply {
                this.index = index
                list.adapter = adapter

                itemView.viewTreeObserver.addOnScrollChangedListener {
                    if (itemView.y <= 0) {
                        val newY = padding10 - itemView.y
                        val maximumY =
                            itemView.measuredHeight - padding10 - moveView.measuredHeight
                        moveView.y = newY.coerceAtMost(maximumY)
                    } else {
                        moveView.y = padding10
                    }
                }
            }
        }
    }
}