package com.moizest89.domain.utils

sealed class DataHandler<out T : Any> {
    data class onSuccess<T : Any>(var data: T) : DataHandler<T>()
    data class onError(val cause: Exception? = null, val message: String? = null) :
        DataHandler<Nothing>()

    data class onLoad(val loading: Boolean) : DataHandler<Nothing>()

    inline fun onLeft(action: (cause: Exception?, message: String?) -> Unit): DataHandler<T> =
        also { if (it is onError) action(it.cause, it.message) }

    inline fun onRight(action: (T) -> Unit): DataHandler<T> =
        also { if (it is onSuccess) action(it.data) }

    fun isSuccess(): Boolean {
        return this is onSuccess
    }
}
