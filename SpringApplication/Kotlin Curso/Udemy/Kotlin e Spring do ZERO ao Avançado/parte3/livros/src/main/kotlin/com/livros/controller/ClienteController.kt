package com.livros.controller

import com.livros.model.dto.ClienteRequestDto
import com.livros.model.dto.ClienteAtualizaRequestDto
import com.livros.model.dto.response.ClienteResponse
import com.livros.extension.toCustomerModel
import com.livros.extension.toResponse
import com.livros.service.ClienteService
import jakarta.validation.Valid

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("clientes")
class ClienteController(
    val clienteService : ClienteService
) {

     @GetMapping
    fun buscarTodos(@RequestParam name: String?): List<ClienteResponse> {
        return clienteService.buscarTodos(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody @Valid customer: ClienteRequestDto) {
       clienteService.criar(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): ClienteResponse {
        return clienteService.buscarPorId(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizar(@PathVariable id: Int, @RequestBody @Valid customer: ClienteAtualizaRequestDto) {
        val customerSaved = clienteService.buscarPorId(id)
        clienteService.atualizar(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluir(@PathVariable id: Int) {
        clienteService.excluir(id)
    }
}