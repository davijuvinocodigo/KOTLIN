package springboot_event.events.publisher

import springboot_event.events.AuditEvent
import springboot_event.events.RequestLogDto
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import springboot_event.utils.RequestUtils

@Component
class AuditEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    fun publishEvent(message: String) {
        val data = RequestUtils.requestData().toMutableMap()
        data["message"] = message
        applicationEventPublisher.publishEvent(
            AuditEvent(
                RequestLogDto(data = data)
            )
        )
    }
}