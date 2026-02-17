package com.livros.utils

import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

object RequestUtils {
    fun requestData(): Map<String, Any> {
        val requestData = mutableMapOf<String, Any>()
        val request: HttpServletRequest = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        requestData["host"] = request.getHeader("host") ?: ""
        requestData["User-Agent"] = request.getHeader("User-Agent") ?: ""
        return requestData
    }
}