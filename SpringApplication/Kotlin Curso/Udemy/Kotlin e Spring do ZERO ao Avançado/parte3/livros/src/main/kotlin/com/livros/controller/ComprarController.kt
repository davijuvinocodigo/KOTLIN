package com.livros.controller

import com.livros.model.dto.POSTCompraDTO
import com.livros.model.dto.CompraDTO
import com.livros.model.mappers.CompraMapper
import com.livros.service.CompraService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comprar")
class ComprarController (
    private val compraService: CompraService,
    private val compraMapper: CompraMapper
) {

    @PostMapping
    fun adicionarCompra(@RequestBody compraDTO: CompraDTO): String {
        compraService.processarComprar(
            pedidoId = generatePedidoId(),
            clienteId = compraDTO.clienteId,
            produtoId = compraDTO.produtoId,
            quantidade = compraDTO.quantidade,
            valorTotal = compraDTO.valor
        )
        return "Compra processada com sucesso!"
    }


    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    fun adicionar(@RequestBody POSTCompraDTO: POSTCompraDTO) {

        compraService.adicionar(compraMapper.toModel(POSTCompraDTO))
    }


    private fun generatePedidoId(): String {
        return "ORD-${System.currentTimeMillis()}"
    }


}