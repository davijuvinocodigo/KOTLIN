package com.livros.extension

import com.livros.model.dto.LivroRequestDto
import com.livros.model.dto.ClienteRequestDto
import com.livros.model.dto.LivroRequestAtualizaDto
import com.livros.model.dto.ClienteAtualizaRequestDto
import com.livros.model.dto.response.LivroResponse
import com.livros.model.dto.response.ClienteResponse
import com.livros.model.enums.LivroStatus
import com.livros.model.enums.ClienteStatus
import com.livros.model.Livro
import com.livros.model.Cliente


fun ClienteRequestDto.toCustomerModel(): Cliente {
    return Cliente(nome = this.nome, email = this.email, status = ClienteStatus.ATIVO)
}

fun ClienteAtualizaRequestDto.toCustomerModel(previousValue: Cliente): Cliente {
    return Cliente(id = previousValue.id, nome = this.name, email = this.email, status = previousValue.status)
}

fun LivroRequestDto.toBookModel(customer: Cliente): Livro {
    return Livro(
        nome = this.nome,
        valor = this.valor,
        status = LivroStatus.ATIVO,
        cliente = customer
    )
}

fun LivroRequestAtualizaDto.toBookModel(previousValue: Livro): Livro {
    return Livro(
        id = previousValue.id,
        nome = this.name ?: previousValue.nome,
        valor = this.price ?: previousValue.valor,
        status = previousValue.status,
        cliente = previousValue.cliente
    )
}

fun Cliente.toResponse(): ClienteResponse {
    return ClienteResponse(
        id = this.id,
        nome = this.nome,
        email = this.email,
        status = this.status
    )
}

fun Livro.toResponse(): LivroResponse {
    return LivroResponse(
        id = this.id,
        nome = this.nome,
        valor = this.valor,
        cliente = this.cliente,
        status = this.status
    )
}