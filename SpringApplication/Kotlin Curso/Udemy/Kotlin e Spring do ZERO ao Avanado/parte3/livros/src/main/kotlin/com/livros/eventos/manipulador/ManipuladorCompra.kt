// ...existing code...
package com.livros.eventos.manipulador

import com.livros.eventos.AuditoriaCompra
import com.livros.service.CompraService
import com.livros.service.LivroService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ManipuladorCompra(
    private val livroService: LivroService,
    private val compraService: CompraService
) : ManipuladorEvento<AuditoriaCompra>() {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun processar(evento: AuditoriaCompra) {
        logger.info("ManipuladorCompra processando nota fiscal: {}", evento.tipo)
        val compraComNfe = evento.dados.copy(nfe = UUID.randomUUID().toString())
        val livrosCompra = evento.dados.livros

        compraService.atualizar(compraComNfe)
        livroService.comprar(livrosCompra)
    }
}
// ...existing code...
