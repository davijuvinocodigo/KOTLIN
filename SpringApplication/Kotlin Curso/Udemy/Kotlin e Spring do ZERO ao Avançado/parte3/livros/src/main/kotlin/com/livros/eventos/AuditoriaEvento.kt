package com.livros.eventos

import org.springframework.context.ApplicationEvent
import java.time.LocalDateTime
import java.util.UUID


abstract class AuditEvent<T>(
    source: Any,
    val data: T,
    val id: String = UUID.randomUUID().toString(),
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val type: String
) : ApplicationEvent(source)