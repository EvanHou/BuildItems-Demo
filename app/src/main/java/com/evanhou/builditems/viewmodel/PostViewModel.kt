package com.evanhou.builditems.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evanhou.builditems.PageState
import com.evanhou.builditems.model.PostBody
import com.evanhou.builditems.model.PostComment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    val pageState = MutableLiveData<PageState<List<PostItem>>>()
    val interaction = MutableLiveData<PostAction>()

    init {
        fetch()
    }

    fun fetch() = viewModelScope.launch {
        pageState.value = PageState.Loading(pageState.value?.data)
        val postBody = loadPostBody()
        val adUrl = loadAdUrl()
        val postComments = loadPostComments()
        val items = buildItems(postBody, adUrl, postComments)
        pageState.value = PageState.Success(items)
    }

    private suspend fun loadAdUrl(): String {
        delay(200)
        return "https://dcard.tw"
    }

    private suspend fun loadPostBody(): PostBody {
        delay(200)
        return PostBody(
            authorName = "Karen",
            content = "Content"
        )
    }

    private suspend fun loadPostComments(): List<PostComment> {
        delay(200)
        return listOf(
            PostComment(
                authorName = "Kyle",
                content = "Content"
            ),
            PostComment(
                authorName = "Ken",
                content = "Content"
            )
        )
    }

    private fun buildItems(
        postBody: PostBody,
        adUrl: String,
        postComments: List<PostComment>
    ): List<PostItem> = mutableListOf<PostItem>().apply {
        add(
            PostItem.Body(
                data = postBody,
                action = interaction
            )
        )
        add(
            PostItem.Ad(
                url = adUrl,
                action = interaction
            )
        )
        addAll(
            postComments.mapIndexed { index, comment ->
                PostItem.Comment(
                    data = comment,
                    floor = index + 1,
                    action = interaction
                )
            }
        )
    }

}