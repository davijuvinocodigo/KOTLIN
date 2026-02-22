package com.livros.controller

import com.livros.model.dto.ClienteRequisicaoDto
import com.livros.model.dto.ClienteAtualizacaoDto
import com.livros.model.dto.resposta.ClienteResposta
import com.livros.extensao.paraResposta
import com.livros.service.ClienteService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("clientes")
class ClienteController(
    private val clienteService: ClienteService
) {

    @GetMapping
    fun buscarTodos(@RequestParam nome: String?): List<ClienteResposta> {
        return clienteService.buscarTodos(nome).map { it.paraResposta() }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody @Valid requisicao: ClienteRequisicaoDto) {
        clienteService.criar(requisicao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): ClienteResposta {
        return clienteService.buscarPorId(id).paraResposta()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizar(@PathVariable id: Int, @RequestBody @Valid requisicao: ClienteAtualizacaoDto) {
        clienteService.atualizar(id, requisicao)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluir(@PathVariable id: Int) {
        clienteService.excluir(id)
    }
}