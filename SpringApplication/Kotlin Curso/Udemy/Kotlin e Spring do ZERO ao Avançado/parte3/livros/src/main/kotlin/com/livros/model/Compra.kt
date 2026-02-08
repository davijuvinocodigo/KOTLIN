package com.livros.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "compra")
data class Compra (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    val cliente: Cliente,

    @ManyToMany
    @JoinTable(name = "compra_livro",
        joinColumns = [JoinColumn(name = "compra_id")],
        inverseJoinColumns = [JoinColumn(name = "livro_id")])
    val livros: MutableList<Livro>,

    @Column
    val nfe: String? = null,

    @Column
    val valor: BigDecimal,

    @Column(name = "criado_em")
    val criadoEm: LocalDateTime = LocalDateTime.now()
)