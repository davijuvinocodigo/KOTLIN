package com.livros.service

import com.livros.events.CompraRealizadaEvent
import com.livros.model.Compra
import com.livros.repository.CompraRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class CompraService (

    private val compraRepository: CompraRepository,
    private val applicationEventPublisher: ApplicationEventPublisher

) {

    fun criar(compra: Compra){
        compraRepository.save(compra)

        println("Disparando evento de compra")
        applicationEventPublisher.publishEvent(CompraRealizadaEvent(this, compra))
        println("Finalização do processamento!")
    }

    fun atualizar(compra: Compra) {
        compraRepository.save(compra)
    }
}
