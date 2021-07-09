package com.evanhou.builditems

/**
 * @author Batu
 */
sealed class PageState<out T> {

    abstract val data: T?

    data class Success<T>(override val data: T) : PageState<T>()
    data class Loading<T>(override val data: T? = null) : PageState<T>()
    data class Error(val throwable: Throwable) : PageState<Nothing>() {
        override val data = null
    }
}