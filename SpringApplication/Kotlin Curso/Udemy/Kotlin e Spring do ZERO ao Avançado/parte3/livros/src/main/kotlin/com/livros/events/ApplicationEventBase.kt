package com.livros.events

import com.livros.model.Compra
import org.springframework.context.ApplicationEvent

class ApplicationCompraEvent(
    source: Any,
    val compra: Compra
): ApplicationEvent(source) {
}