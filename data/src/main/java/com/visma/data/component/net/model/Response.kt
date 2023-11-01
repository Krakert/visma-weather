package com.visma.data.component.net.model

import io.ktor.client.statement.HttpResponse

data class Response<T>(
    val response: HttpResponse
)
