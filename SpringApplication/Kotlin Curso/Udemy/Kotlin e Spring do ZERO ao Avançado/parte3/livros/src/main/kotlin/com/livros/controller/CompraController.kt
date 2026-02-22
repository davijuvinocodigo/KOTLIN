package com.livros.controller

import com.livros.model.dto.CompraRequisicaoDto
import com.livros.model.mappers.CompraMapper
import com.livros.service.CompraService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/compras")
class CompraController(
    private val compraService: CompraService,
    private val compraMapper: CompraMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody requisicao: CompraRequisicaoDto) {
        compraService.criar(compraMapper.paraModelo(requisicao))
    }
}