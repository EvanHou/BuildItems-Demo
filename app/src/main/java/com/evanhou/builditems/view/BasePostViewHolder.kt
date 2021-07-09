package com.evanhou.builditems.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.evanhou.builditems.viewmodel.PostItem

abstract class BasePostViewHolder<in T : PostItem>(
    parent: ViewGroup,
    @LayoutRes layoutResId: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
) {
    abstract fun bind(item: T)
}