package com.livros.service


import com.livros.model.enums.LivroStatus
import com.livros.model.enums.Errors
import com.livros.exception.NotFoundException
import com.livros.model.Livro
import com.livros.model.Cliente
import com.livros.repository.LivroRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LivroService(
    private val livroRepository: LivroRepository
) {

    fun criar(livro: Livro) = livroRepository.save(livro)

    fun buscarTodos(paginacao: Pageable): Page<Livro> = livroRepository.findAll(paginacao)

    fun buscarAtivos(paginacao: Pageable): Page<Livro> =
        livroRepository.findByStatus(LivroStatus.ATIVO, paginacao)

    fun buscarPorId(id: Int): Livro =
        livroRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code) }

    @Transactional
    fun excluir(id: Int) {
        val livro = buscarPorId(id)
        livro.status = LivroStatus.CANCELADO
        livroRepository.save(livro)
    }

    fun atualizar(livro: Livro) = livroRepository.save(livro)

    @Transactional
    fun excluirPorCliente(cliente: Cliente) {
        val livros = livroRepository.findByCliente(cliente)
        livros.forEach { it.status = LivroStatus.DELETADO }
        livroRepository.saveAll(livros)
    }

    fun buscarTodosPorIds(livroIds: Set<Int>): List<Livro> =
        livroRepository.findAllById(livroIds).toList()

    @Transactional
    fun comprar(livros: MutableList<Livro>) {
        livros.forEach { it.status = LivroStatus.VENDIDO }
        livroRepository.saveAll(livros)
    }
}