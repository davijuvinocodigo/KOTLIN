package com.livros.repository

import com.livros.model.enums.LivroStatus
import com.livros.model.Livro
import com.livros.model.Cliente
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository : JpaRepository<Livro, Int> {

    fun findByStatus(status: LivroStatus, pageable: Pageable): Page<Livro>
    fun findByCliente(cliente: Cliente): List<Livro>

}