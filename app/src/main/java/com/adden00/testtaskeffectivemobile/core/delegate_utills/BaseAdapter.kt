package com.adden00.testtaskeffectivemobile.core.delegate_utills

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter :
    ListAdapter<DelegateItem, RecyclerView.ViewHolder>(DelegateAdapterItemCallback()) {
    private val delegateAdapters = mutableListOf<AdapterDelegate>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters[viewType].onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        delegateAdapters[viewType].onBindViewHolder(holder, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        val index = delegateAdapters.indexOfFirst {
            it.isOfViewType(currentList[position])
        }
        return index
    }

    fun addDelegate(delegate: AdapterDelegate) {
        delegateAdapters.add(delegate)
    }
}

