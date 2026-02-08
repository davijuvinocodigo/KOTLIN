package com.livros.model.mappers

import com.livros.model.Compra
import com.livros.model.dto.POSTCompraDTO
import com.livros.service.ClienteService
import com.livros.service.LivroService
import org.springframework.stereotype.Component

@Component
class CompraMapper(private val livroService: LivroService, private val clienteService: ClienteService) {

    fun toModel(POSTCompraDTO: POSTCompraDTO): Compra {
        val livros = livroService.buscarTodosPorIds(POSTCompraDTO.livroIds)
        val cliente = clienteService.findById(POSTCompraDTO.clienteId)

        return Compra(
            cliente = cliente,
            livros = livros.toMutableList(),
            valor = livros.sumOf { it.valor }
        )
    }
}