package com.evanhou.builditems.view

import android.view.ViewGroup
import com.evanhou.builditems.R
import com.evanhou.builditems.viewmodel.PostAction
import com.evanhou.builditems.viewmodel.PostItem
import kotlinx.android.synthetic.main.view_holder_ad.view.*

class AdViewHolder(parent: ViewGroup) : BasePostViewHolder<PostItem.Ad>(
    parent, R.layout.view_holder_ad
) {
    override fun bind(item: PostItem.Ad) {
        itemView.imageView.setOnClickListener {
            item.action?.value = PostAction.Ad(url = item.url)
        }
    }
}