package com.livros.controller

import com.livros.model.dto.LivroRequisicaoDto
import com.livros.model.dto.LivroAtualizacaoDto
import com.livros.model.dto.resposta.LivroResposta
import com.livros.extensao.paraResposta
import com.livros.service.LivroService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("livros")
class LivroController(
    private val livroService: LivroService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody @Valid requisicao: LivroRequisicaoDto) {
        livroService.criar(requisicao)
    }

    @GetMapping
    fun buscarTodos(@PageableDefault(page = 0, size = 10) paginacao: Pageable): Page<LivroResposta> {
        return livroService.buscarTodos(paginacao).map { it.paraResposta() }
    }

    @GetMapping("/ativos")
    fun buscarAtivos(@PageableDefault(page = 0, size = 10) paginacao: Pageable): Page<LivroResposta> {
        return livroService.buscarAtivos(paginacao).map { it.paraResposta() }
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): LivroResposta {
        return livroService.buscarPorId(id).paraResposta()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluir(@PathVariable id: Int) {
        livroService.excluir(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun atualizar(@PathVariable id: Int, @RequestBody livro: LivroAtualizacaoDto) {
        livroService.atualizar(id, livro)
    }
}