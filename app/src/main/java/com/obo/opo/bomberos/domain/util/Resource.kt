package com.obo.opo.bomberos.domain.util

import com.obo.opo.bomberos.domain.model.Question
import java.lang.Exception

// Estados
sealed class Resource<out T> {

    object Loading: Resource<Nothing>()

    data class Success<out T>(val data: T): Resource<T>()

    data class Failure<out T>(val message: String): Resource<T>()

}
