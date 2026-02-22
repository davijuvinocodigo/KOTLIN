package com.livros.repository


import com.livros.model.Cliente
import org.springframework.data.repository.CrudRepository

interface ClienteRepository : CrudRepository<Cliente, Int> {
    fun findByNomeContaining(nome: String): List<Cliente>
    fun existsByEmail(email: String): Boolean
}