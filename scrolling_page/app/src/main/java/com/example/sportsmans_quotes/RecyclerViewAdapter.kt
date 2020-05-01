package com.example.sportsmans_quotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recyclerview_layout.view.*

class RecyclerViewAdapter(private val items: MutableList<Item>,
                          private val removeitem: RemoveItem) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recyclerview_layout, parent, false)
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var model: Item

        fun onBind() {
            model = items[adapterPosition]
            itemView.imageView.setImageResource(model.image)
            itemView.titleTextView.text = model.title
            itemView.descriptionTextView.text = model.description
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            removeitem.onClick(adapterPosition)
        }

    }
    }
