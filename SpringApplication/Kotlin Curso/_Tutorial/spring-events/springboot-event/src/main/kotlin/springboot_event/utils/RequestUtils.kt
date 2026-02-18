package springboot_event.utils

import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


object RequestUtils {
    fun requestData(): Map<String, String> {
        val requestData = mutableMapOf<String, String>()
        val request: HttpServletRequest = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        requestData["host"] = request.getHeader("host") ?: ""
        requestData["User-Agent"] = request.getHeader("User-Agent") ?: ""
        return requestData
    }
}