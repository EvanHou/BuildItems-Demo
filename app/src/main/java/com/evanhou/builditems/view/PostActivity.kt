package com.evanhou.builditems.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.evanhou.builditems.*
import com.evanhou.builditems.viewmodel.PostAction
import com.evanhou.builditems.viewmodel.PostItem
import com.evanhou.builditems.viewmodel.PostViewModel
import kotlinx.android.synthetic.main.activity_main.*

class PostActivity : AppCompatActivity() {

    private val viewModel: PostViewModel by viewModels()

    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupViewModel()
    }

    private fun setupViews() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PostAdapter().also { this@PostActivity.adapter = it }
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun setupViewModel() {
        viewModel.pageState.observe(this) {
            handlePageState(it)
        }
        viewModel.interaction.observe(this) {
            handleInteraction(it)
        }
    }

    private fun handlePageState(state: PageState<List<PostItem>>) {
        // handle page state
        state.data?.let { adapter.data = it }
    }

    private fun handleInteraction(action: PostAction) {
        when (action) {
            is PostAction.Body -> handleBodyAction(action)
            is PostAction.Comment -> handleCommentAction(action)
            is PostAction.Ad -> handleAdOpening(action.url)
        }
    }

    private fun handleBodyAction(action: PostAction.Body) {
        when (action.type) {
            PostAction.Body.Type.Like -> {}
            PostAction.Body.Type.Save -> {}
        }
    }

    private fun handleCommentAction(action: PostAction.Comment) {
        when (action.type) {
            PostAction.Comment.Type.Like -> {}
            PostAction.Comment.Type.Reply -> {}
            PostAction.Comment.Type.Report -> {}
        }
    }

    private fun handleAdOpening(url: String) {

    }

}