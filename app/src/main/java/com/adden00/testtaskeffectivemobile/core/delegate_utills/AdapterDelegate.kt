package com.adden00.testtaskeffectivemobile.core.delegate_utills

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


interface AdapterDelegate {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: DelegateItem)
    fun isOfViewType(item: DelegateItem): Boolean
}
