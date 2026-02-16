package springboot_event.events

import org.springframework.context.ApplicationEvent


class AuditEvent<T: Any>(source: T) : ApplicationEvent(source)
