package com.livros.service

import com.livros.events.ComprarEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ComprarService (

    private val eventPublicar: ApplicationEventPublisher
) {

    fun processarComprar(pedidoId: String, clienteId: String, produtoId: String, quantidade: Int, valorTotal: Double) {
        println()
        println("=== Servico de Compra: Processando pedido $pedidoId ===")

        // Lógica de processamento da compra
        println("Compra processada: $pedidoId para clientes $clienteId")

        // Publica o evento
        val event = ComprarEvent(pedidoId, clienteId, produtoId, quantidade, valorTotal, LocalDateTime.now())
        eventPublicar.publishEvent(event)

        println("Evento publicado para outros serviços")
    }
}
