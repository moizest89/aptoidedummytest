package com.moizest89.aptoidedummytest.presentation.app.applist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.moizest89.aptoidedummytest.databinding.ItemAppListBinding
import com.moizest89.domain.model.apps.AppItem

class AppListAdapter(
    private val data: MutableList<AppItem> = mutableListOf(),
    private val onClickItem: (AppItem, position: Int) -> Unit
) : RecyclerView.Adapter<AppListAdapter.ItemHolder>() {

    inner class ItemHolder(val binding: ItemAppListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val textViewAppName = binding.textViewAppName
        private val imageViewBanner = binding.imageViewBanner
        private val imageViewLogo = binding.imageViewLogo
        fun setData(appItem: AppItem) {
            textViewAppName.text = appItem.name
            imageViewBanner.load(appItem.graphic) {
                crossfade(true)
            }
            imageViewLogo.load(appItem.icon) {
                crossfade(true)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = ItemAppListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    fun reloadData(newData: MutableList<AppItem> = mutableListOf(),){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val itemData = data[position]
        holder.setData(itemData)
        holder.itemView.setOnClickListener {
            onClickItem.invoke(itemData, position)
        }
    }
}
