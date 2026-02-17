package com.livros.service

import com.livros.events.AuditEvent
import com.livros.events.publisher.AuditEventPublisher
import com.livros.model.Compra
import com.livros.repository.CompraRepository
import org.springframework.stereotype.Service

@Service
class CompraService (

    private val compraRepository: CompraRepository,
    private val auditEventPublisher: AuditEventPublisher

) {

    fun criar(compra: Compra){
        compraRepository.save(compra)

        println("Disparando evento de compra")
        auditEventPublisher.publishEvent(AuditEvent(this))
        println("Finalização do processamento!")
    }

    fun atualizar(compra: Compra) {
        compraRepository.save(compra)
    }
}
