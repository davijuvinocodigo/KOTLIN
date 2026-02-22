package com.livros.eventos

import org.springframework.context.ApplicationEvent
import java.time.LocalDateTime
import java.util.UUID

abstract class AuditoriaEvento<T>(
    source: Any,
    val dados: T,
    val id: String = UUID.randomUUID().toString(),
    val dataHora: LocalDateTime = LocalDateTime.now(),
    val tipo: String
) : ApplicationEvent(source)