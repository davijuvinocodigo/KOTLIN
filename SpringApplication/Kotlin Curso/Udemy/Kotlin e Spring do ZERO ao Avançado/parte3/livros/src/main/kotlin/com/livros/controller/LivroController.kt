package com.livros.controller

import com.livros.model.dto.POSTLivroDTO
import com.livros.model.dto.PUTLivroDTO
import com.livros.model.dto.response.LivroRESP
import com.livros.extension.toBookModel
import com.livros.extension.toResponse
import com.livros.service.LivroService
import com.livros.service.ClienteService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("livros")
class LivroController(
    val livroService: LivroService,
    val clienteService: ClienteService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody @Valid request: POSTLivroDTO) {
        val customer = clienteService.buscarPorId(request.clienteId)
        livroService.criar(request.toBookModel(customer))
    }

    @GetMapping
    fun buscarTodos(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<LivroRESP> {
        return livroService.buscarTodos(pageable).map { it.toResponse() }
    }

    @GetMapping("/active")
    fun buscarAtivos(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<LivroRESP> =
        livroService.buscarAtivos(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): LivroRESP {
        return livroService.buscarPorId(id).toResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluir(@PathVariable id: Int) {
        livroService.excluir(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizar(@PathVariable id: Int, @RequestBody book: PUTLivroDTO) {
        val livroSaved = livroService.buscarPorId(id)
        livroService.atualizar(book.toBookModel(livroSaved))
    }

}