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
    fun create(@RequestBody @Valid request: POSTLivroDTO) {
        val customer = clienteService.findById(request.clienteId)
        livroService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<LivroRESP> {
        return livroService.findAll(pageable).map { it.toResponse() }
    }

    @GetMapping("/active")
    fun findActives(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<LivroRESP> =
        livroService.findActives(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): LivroRESP {
        return livroService.findById(id).toResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        livroService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PUTLivroDTO) {
        val bookSaved = livroService.findById(id)
        livroService.update(book.toBookModel(bookSaved))
    }

}