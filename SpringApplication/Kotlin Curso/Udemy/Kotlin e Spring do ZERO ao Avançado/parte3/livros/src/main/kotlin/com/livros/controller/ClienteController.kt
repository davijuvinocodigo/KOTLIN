package com.livros.controller

import com.livros.model.dto.POSTClienteDTO
import com.livros.model.dto.PUTClienteDTO
import com.livros.model.dto.response.ClienteRESP
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
    fun buscarTodos(@RequestParam name: String?): List<ClienteRESP> {
        return clienteService.buscarTodos(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody @Valid customer: POSTClienteDTO) {
       clienteService.criar(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): ClienteRESP {
        return clienteService.buscarPorId(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizar(@PathVariable id: Int, @RequestBody @Valid customer: PUTClienteDTO) {
        val customerSaved = clienteService.buscarPorId(id)
        clienteService.atualizar(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluir(@PathVariable id: Int) {
        clienteService.excluir(id)
    }
}