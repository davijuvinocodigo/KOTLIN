package com.livros.controller

import com.livros.model.dto.POSTCompraDTO
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
    @ResponseStatus(HttpStatus.CREATED)
    fun adicionar(@RequestBody postCompraDTO: POSTCompraDTO) {
        compraService.criar(compraMapper.toModel(postCompraDTO))
    }

}