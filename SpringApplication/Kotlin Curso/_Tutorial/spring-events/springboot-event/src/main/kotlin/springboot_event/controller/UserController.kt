package springboot_event.controller

import springboot_event.events.publisher.AuditEventPublisher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import springboot_event.model.User

@RestController
@RequestMapping("/users")
class UserController(
    private val auditEventPublisher: AuditEventPublisher
) {

    @PostMapping
    fun register(@RequestBody user: User): String {
        auditEventPublisher.publishEvent("User is saved, username: ${user.userName}")
        return "User saved successfully."
    }
}