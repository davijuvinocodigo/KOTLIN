package com.livros.service

import com.livros.eventos.AuditoriaCompra
import com.livros.eventos.publicador.PublicadorAssincrono
import com.livros.model.Compra
import com.livros.repository.CompraRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CompraService(
    private val compraRepository: CompraRepository,
    private val publicadorAssincrono: PublicadorAssincrono<AuditoriaCompra>
) {

    private val logger = LoggerFactory.getLogger(javaClass)

    fun criar(compra: Compra): Compra {
        val compraSalva = compraRepository.save(compra)
        logger.info("Publicando evento de compra de forma assíncrona...")
        publicadorAssincrono.publicar(AuditoriaCompra(this, compraSalva))
        logger.info("Fim da publicação do evento de compra.")
        return compraSalva
    }

    fun atualizar(compra: Compra) {
        compraRepository.save(compra)
    }
}
