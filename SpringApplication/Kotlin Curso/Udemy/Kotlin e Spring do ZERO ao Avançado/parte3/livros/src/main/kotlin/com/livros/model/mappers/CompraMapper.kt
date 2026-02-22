package com.livros.model.mappers

import com.livros.model.dto.CompraRequisicaoDto
import com.livros.modelo.Compra
import com.livros.service.ClienteService
import com.livros.service.LivroService
import org.springframework.stereotype.Component

@Component
class CompraMapper(
    private val livroService: LivroService,
    private val clienteService: ClienteService
) {

    fun paraModelo(requisicao: CompraRequisicaoDto): Compra {
        val livros = livroService.buscarTodosPorIds(requisicao.livroIds)
        val cliente = clienteService.buscarPorId(requisicao.clienteId)

        return Compra(
            cliente = cliente,
            livros = livros.toMutableList(),
            valor = livros.sumOf { it.valor }
        )
    }
}