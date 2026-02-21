package com.livros.service

import com.livros.events.AuditCompra
import com.livros.events.AuditEvent
import com.livros.events.publisher.PublisherAsynchronous
import com.livros.events.publisher.PublisherEvent
import com.livros.events.publisher.PublisherSynchronous
import com.livros.model.Compra
import com.livros.repository.CompraRepository
import org.springframework.stereotype.Service

@Service
class CompraService (

    private val compraRepository: CompraRepository,
    private val publisherSynchronous: PublisherSynchronous<AuditEvent<*>>,
    private val publisherAsynchronous: PublisherAsynchronous<AuditEvent<*>>

) {

    fun criar(compra: Compra){
        compraRepository.save(compra)

        println("Publicando evento de compra de forma assíncrona...")
        val event = AuditCompra(this, compra)
        publisherAsynchronous.publish(event)

        println("Fim da publicação do evento de compra.")
    }

    fun atualizar(compra: Compra) {
        compraRepository.save(compra)
    }
}
