package com.evanhou.builditems.viewmodel

import androidx.lifecycle.MutableLiveData
import com.evanhou.builditems.model.PostBody
import com.evanhou.builditems.model.PostComment

sealed class PostItem {

    data class Ad(
        val url: String,
        val action: MutableLiveData<PostAction>?
    ) : PostItem()

    data class Body(
        val data: PostBody,
        val action: MutableLiveData<PostAction>?
    ) : PostItem()

    class Comment(
        val data: PostComment,
        val floor: Int,
        val action: MutableLiveData<PostAction>?
    ) : PostItem()
}