package com.livros.model

import com.livros.model.enums.ClienteStatus
import jakarta.persistence.*

@Entity(name = "cliente")
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var nome: String,

    @Column
    var email: String,

    @Column
    @Enumerated(EnumType.STRING)
    var status: ClienteStatus
)