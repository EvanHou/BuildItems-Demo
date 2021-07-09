package com.evanhou.builditems.viewmodel

import com.evanhou.builditems.model.PostBody
import com.evanhou.builditems.model.PostComment

sealed class PostAction {

    data class Ad(val url: String): PostAction()

    data class Body(
        val data: PostBody,
        val type: Type
    ) : PostAction() {
        enum class Type {
            Like, Save
        }
    }

    data class Comment(
        val data: PostComment,
        val type: Type
    ) : PostAction() {
        enum class Type {
            Like, Reply, Report
        }
    }

}
