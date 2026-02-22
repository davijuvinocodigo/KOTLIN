package com.livros.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity(name = "compra")
data class Compra(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    val cliente: Cliente,

    @ManyToMany
    @JoinTable(
        name = "compra_livro",
        joinColumns = [JoinColumn(name = "compra_id")],
        inverseJoinColumns = [JoinColumn(name = "livro_id")]
    )
    val livros: MutableList<Livro>,

    @Column
    val nfe: String? = null,

    @Column
    val valor: BigDecimal,

    @Column(name = "criado_em")
    val criadoEm: LocalDateTime = LocalDateTime.now()
)