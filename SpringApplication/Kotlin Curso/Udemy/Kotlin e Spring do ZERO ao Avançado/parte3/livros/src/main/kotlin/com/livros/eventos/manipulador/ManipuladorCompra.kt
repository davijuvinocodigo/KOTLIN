package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaCompra
import com.livros.service.CompraService
import com.livros.service.LivroService
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ManipuladorCompra(
    private val livroService: LivroService,
    private val compraService: CompraService
) : ManipuladorEvento<AuditoriaCompra>() {

    override fun processar(evento: AuditoriaCompra) {
        println("📄 ManipuladorCompra processando nota fiscal: ${evento.tipo}")
        val compraComNfe = evento.dados.copy(nfe = UUID.randomUUID().toString())
        val livrosCompra = evento.dados.livros

        compraService.atualizar(compraComNfe)
        livroService.comprar(livrosCompra)
    }
}