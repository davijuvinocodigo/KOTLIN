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

@Service
class LivroService(
    val livroRepository: LivroRepository
) {

    fun create(book: Livro) {
        livroRepository.save(book)
    }

    fun findAll(pageable: Pageable): Page<Livro> {
        return livroRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<Livro> {
        return livroRepository.findByStatus(LivroStatus.ATIVO, pageable)
    }

    fun findById(id: Int): Livro {
        return livroRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code) }
    }

    fun delete(id: Int) {
        val book = findById(id)

        book.status = LivroStatus.CANCELADO

        update(book)
    }

    fun update(book: Livro) {
        livroRepository.save(book)
    }

    fun deleteByCustomer(customer: Cliente) {
        val books = livroRepository.findByCliente(customer)
        for(book in books) {
            book.status = LivroStatus.DELETADO
        }
        livroRepository.saveAll(books)
    }

    fun buscarTodosPorIds(livroIds: Set<Int>): List<Livro> {
        return livroRepository.findAllById(livroIds).toList()
    }

    fun compra(livros: MutableList<Livro>) {
        livros.map { it.status = LivroStatus.VENDIDO }
        livroRepository.saveAll(livros)
    }


}
