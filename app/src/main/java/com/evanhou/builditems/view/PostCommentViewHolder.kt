package com.evanhou.builditems.view

import android.view.ViewGroup
import android.widget.PopupMenu
import com.evanhou.builditems.R
import com.evanhou.builditems.viewmodel.PostAction
import com.evanhou.builditems.viewmodel.PostItem
import kotlinx.android.synthetic.main.view_holder_post_comment.view.*

class PostCommentViewHolder(parent: ViewGroup) : BasePostViewHolder<PostItem.Comment>(
    parent, R.layout.view_holder_post_comment
) {
    override fun bind(item: PostItem.Comment) {
        itemView.author.text = item.data.authorName
        itemView.floor.text = "B${item.floor}"
        itemView.content.text = item.data.content
        itemView.like.setOnClickListener {
            item.action?.value = PostAction.Comment(item.data, PostAction.Comment.Type.Like)
        }
        itemView.reply.setOnClickListener {
            item.action?.value = PostAction.Comment(item.data, PostAction.Comment.Type.Reply)
        }
        itemView.more.setOnClickListener {
            PopupMenu(itemView.context, itemView.more).apply {
                menu.add("檢舉")
                setOnMenuItemClickListener {
                    item.action?.value = PostAction.Comment(item.data, PostAction.Comment.Type.Report)
                    true
                }
            }.show()
        }
    }
}