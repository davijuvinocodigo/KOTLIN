package com.livros.service

import com.livros.events.ApplicationEventBase
import com.livros.events.ComprarEvent
import com.livros.model.Compra
import com.livros.repository.CompraRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CompraService (

    private val compraRepository: CompraRepository,
    private val applicationEventPublisher: ApplicationEventPublisher

) {

    fun processarComprar(pedidoId: String, clienteId: String, produtoId: String, quantidade: Int, valorTotal: Double) {
        println()
        println("=== Servico de Compra: Processando pedido $pedidoId ===")

        // Lógica de processamento da compra
        println("Compra processada: $pedidoId para cliente $clienteId")

        // Publica o evento
        val event = ComprarEvent(pedidoId, clienteId, produtoId, quantidade, valorTotal, LocalDateTime.now())
        applicationEventPublisher.publishEvent(event)

        println("Evento publicado para outros serviços")
    }


    fun adicionar(compra: Compra){
        compraRepository.save(compra)

        println("Disparando evento de compra")
        applicationEventPublisher.publishEvent(ApplicationEventBase(this, compra))
        println("Finalização do processamento!")
    }

    fun atualizar(compra: Compra) {
        compraRepository.save(compra)
    }
}
