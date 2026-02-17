package com.livros.events.publisher

import com.livros.events.AuditEvent
import com.livros.events.RequestLogDto
import com.livros.utils.RequestUtils
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class AuditEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    fun publishEvent(message: Any) {
        val data = RequestUtils.requestData().toMutableMap()
        data["message"] = message
        applicationEventPublisher.publishEvent(
            AuditEvent(
                RequestLogDto(data = data)
            )
        )
    }
}