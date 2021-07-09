package com.evanhou.builditems.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evanhou.builditems.viewmodel.PostItem
import kotlin.IllegalArgumentException

class PostAdapter : RecyclerView.Adapter<BasePostViewHolder<*>>() {

    companion object {
        private const val TYPE_BODY = 1
        private const val TYPE_AD = 2
        private const val TYPE_COMMENT = 3
    }

    var data: List<PostItem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is PostItem.Body -> TYPE_BODY
            is PostItem.Ad -> TYPE_AD
            is PostItem.Comment -> TYPE_COMMENT
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasePostViewHolder<*> {
        return when (viewType) {
            TYPE_BODY -> PostBodyViewHolder(parent)
            TYPE_AD -> AdViewHolder(parent)
            TYPE_COMMENT -> PostCommentViewHolder(parent)
            else -> throw IllegalArgumentException("Type is invalid")
        }
    }

    override fun onBindViewHolder(holder: BasePostViewHolder<*>, position: Int) {
        when (holder) {
            is PostBodyViewHolder -> holder.bind(data[position] as PostItem.Body)
            is AdViewHolder -> holder.bind(data[position] as PostItem.Ad)
            is PostCommentViewHolder -> holder.bind(data[position] as PostItem.Comment)
        }
    }

}