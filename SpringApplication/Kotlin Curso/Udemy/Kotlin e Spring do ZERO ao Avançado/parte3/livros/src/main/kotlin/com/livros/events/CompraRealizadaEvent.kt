package com.livros.events

import com.livros.model.Compra
import org.springframework.context.ApplicationEvent

/**
 * Evento personalizado para representar uma compra realizada.
 * Este evento pode ser publicado quando uma nova compra é criada, permitindo que outros componentes do sistema
 * reajam a essa ação, como enviar notificações, atualizar o estoque, etc.
 *
 * @param source O objeto que gerou o evento (geralmente a classe de serviço ou controlador que criou a compra).
 * @param compra A instância da compra que foi realizada.
 */
class CompraRealizadaEvent(
    source: Any,
    val compra: Compra
): ApplicationEvent(source) {
}