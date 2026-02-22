package com.livros.repository

import com.livros.model.Compra
import org.springframework.data.repository.CrudRepository

interface CompraRepository : CrudRepository<Compra, Int>