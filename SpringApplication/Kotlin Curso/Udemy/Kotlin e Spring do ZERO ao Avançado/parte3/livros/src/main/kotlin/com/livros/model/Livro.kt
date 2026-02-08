package com.livros.model

import com.livros.model.enums.LivroStatus
import com.livros.model.enums.Errors
import com.livros.exception.BadRequestException
import jakarta.persistence.*;
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
    var cliente: Cliente? = null

) {

    @Column
    @Enumerated(EnumType.STRING)
    var status: LivroStatus? = null
        set(value) {
            if(field == LivroStatus.CANCELADO || field == LivroStatus.DELETADO)
                throw BadRequestException(Errors.ML102.message.format(field), Errors.ML102.code)

            field = value
        }

    constructor(id: Int? = null,
                nome: String,
                valor: BigDecimal,
                cliente: Cliente? = null,
                status: LivroStatus?): this(id, nome, valor, cliente) {
        this.status = status
    }

}