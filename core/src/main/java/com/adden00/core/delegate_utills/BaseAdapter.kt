package com.adden00.core.delegate_utills

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter :
    ListAdapter<DelegateItem, RecyclerView.ViewHolder>(DelegateAdapterItemCallback()) {
    private val _delegateAdapters = mutableListOf<AdapterDelegate>()
    fun getAdapters() = _delegateAdapters.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return _delegateAdapters[viewType].onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewType = getItemViewType(position)
        _delegateAdapters[viewType].onBindViewHolder(holder, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        val index = _delegateAdapters.indexOfFirst {
            it.isOfViewType(currentList[position])
        }
        return index
    }

    fun addDelegate(delegate: AdapterDelegate) {
        _delegateAdapters.add(delegate)
    }
}

