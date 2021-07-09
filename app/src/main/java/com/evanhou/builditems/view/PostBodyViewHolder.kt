package com.evanhou.builditems.view

import android.view.ViewGroup
import com.evanhou.builditems.R
import com.evanhou.builditems.viewmodel.PostAction
import com.evanhou.builditems.viewmodel.PostItem
import kotlinx.android.synthetic.main.view_holder_post_body.view.*

class PostBodyViewHolder(parent: ViewGroup) : BasePostViewHolder<PostItem.Body>(
    parent, R.layout.view_holder_post_body
) {
    override fun bind(item: PostItem.Body) {
        itemView.author.text = item.data.authorName
        itemView.content.text = item.data.content
        itemView.like.setOnClickListener {
            item.action?.value = PostAction.Body(item.data, PostAction.Body.Type.Like)
        }
        itemView.save.setOnClickListener {
            item.action?.value = PostAction.Body(item.data, PostAction.Body.Type.Save)
        }
    }
}