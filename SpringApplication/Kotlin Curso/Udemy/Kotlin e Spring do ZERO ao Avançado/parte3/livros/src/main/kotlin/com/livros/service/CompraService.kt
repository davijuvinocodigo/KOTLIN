package com.livros.service

import com.livros.eventos.AuditoriaCompra
import com.livros.eventos.publicador.PublicadorAssincrono
import com.livros.model.Compra
import com.livros.repository.CompraRepository
import org.springframework.stereotype.Service

@Service
class CompraService(
    private val compraRepository: CompraRepository,
    private val publicadorAssincrono: PublicadorAssincrono<AuditoriaCompra>
) {

    fun criar(compra: Compra) {
        compraRepository.save(compra)
        println("Publicando evento de compra de forma assíncrona...")
        publicadorAssincrono.publicar(AuditoriaCompra(this, compra))
        println("Fim da publicação do evento de compra.")
    }

    fun atualizar(compra: Compra) {
        compraRepository.save(compra)
    }
}
