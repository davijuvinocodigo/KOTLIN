package com.livros.model

import com.livros.model.enums.LivroStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "livro")
data class Livro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var nome: String,

    @Column
    var valor: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    var cliente: Cliente? = null,

    @Column
    @Enumerated(EnumType.STRING)
    var status: LivroStatus? = null
)