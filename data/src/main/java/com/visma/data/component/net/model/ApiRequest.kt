package com.visma.data.component.net.model

import com.visma.data.component.DataConfig.API_BASE_URL


data class ApiRequest<T>(
    val method: ApiMethod,
    val url: String = API_BASE_URL,
    val path: String,
    val requestBody: Any? = null,
    val parameters: List<Query>? = null
)
