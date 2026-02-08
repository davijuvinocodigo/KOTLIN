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
    fun getAll(@RequestParam name: String?): List<ClienteRESP> {
        return clienteService.getAll(name).map { it.toResponse() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid customer: POSTClienteDTO) {
       clienteService.create(customer.toCustomerModel())
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): ClienteRESP {
        return clienteService.findById(id).toResponse()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody @Valid customer: PUTClienteDTO) {
        val customerSaved = clienteService.findById(id)
        clienteService.update(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        clienteService.delete(id)
    }
}