package com.visma.domain.response

data class BackendException(
    val errorCode: Int
) : Exception()
