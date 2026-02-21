package com.livros.events.handler

import com.livros.events.AuditCompra
import com.livros.service.CompraService
import com.livros.service.LivroService
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class HandleCompra(
    private val livroService: LivroService,
    private val compraService: CompraService,
) : HandlerEvent<AuditCompra>() {

    override fun process(event: AuditCompra) {
        println("👂 ${this.javaClass.simpleName} processando nfe: ${event.type}")
        val compraNfeUpdate = event.data.copy(nfe = UUID.randomUUID().toString())
        val compraLivros = event.data.livros

        compraService.atualizar(compraNfeUpdate)
        livroService.comprar(compraLivros)
    }
}