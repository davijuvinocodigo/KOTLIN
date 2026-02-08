package com.livros.extension

import com.livros.model.dto.POSTLivroDTO
import com.livros.model.dto.POSTClienteDTO
import com.livros.model.dto.PUTLivroDTO
import com.livros.model.dto.PUTClienteDTO
import com.livros.model.dto.response.LivroRESP
import com.livros.model.dto.response.ClienteRESP
import com.livros.model.enums.LivroStatus
import com.livros.model.enums.ClienteStatus
import com.livros.model.Livro
import com.livros.model.Cliente


fun POSTClienteDTO.toCustomerModel(): Cliente {
    return Cliente(nome = this.nome, email = this.email, status = ClienteStatus.ATIVO)
}

fun PUTClienteDTO.toCustomerModel(previousValue: Cliente): Cliente {
    return Cliente(id = previousValue.id, nome = this.name, email = this.email, status = previousValue.status)
}

fun POSTLivroDTO.toBookModel(customer: Cliente): Livro {
    return Livro(
        nome = this.nome,
        valor = this.valor,
        status = LivroStatus.ATIVO,
        cliente = customer
    )
}

fun PUTLivroDTO.toBookModel(previousValue: Livro): Livro {
    return Livro(
        id = previousValue.id,
        nome = this.name ?: previousValue.nome,
        valor = this.price ?: previousValue.valor,
        status = previousValue.status,
        cliente = previousValue.cliente
    )
}

fun Cliente.toResponse(): ClienteRESP {
    return ClienteRESP(
        id = this.id,
        nome = this.nome,
        email = this.email,
        status = this.status
    )
}

fun Livro.toResponse(): LivroRESP {
    return LivroRESP(
        id = this.id,
        nome = this.nome,
        valor = this.valor,
        cliente = this.cliente,
        status = this.status
    )
}