package com.visma.data.component.net.mapper

import com.visma.data.component.net.model.Response
import com.visma.domain.response.AuthException
import com.visma.domain.response.BackendException
import io.ktor.client.call.body
import io.ktor.http.isSuccess
import javax.inject.Inject

class ResponseMapper @Inject constructor() {

    suspend inline fun <reified T> map(httpResponse: Response<T>): Result<T> {
        return if (httpResponse.response.status.isSuccess()) {
            Result.success(httpResponse.response.body())
        } else if (httpResponse.response.status.value == 401) {
            Result.failure(AuthException())
        } else {
            Result.failure(BackendException(errorCode = httpResponse.response.status.value))
        }
    }
}