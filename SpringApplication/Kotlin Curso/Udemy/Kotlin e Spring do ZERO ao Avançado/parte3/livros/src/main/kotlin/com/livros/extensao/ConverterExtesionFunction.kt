package com.livros.extensao

import com.livros.model.dto.ClienteRequisicaoDto
import com.livros.model.dto.ClienteAtualizacaoDto
import com.livros.model.dto.LivroRequisicaoDto
import com.livros.model.dto.LivroAtualizacaoDto
import com.livros.model.dto.resposta.ClienteResposta
import com.livros.model.dto.resposta.LivroResposta
import com.livros.model.enums.ClienteStatus
import com.livros.model.enums.LivroStatus
import com.livros.model.Cliente
import com.livros.model.Livro

fun ClienteRequisicaoDto.paraModelo(): Cliente {
    return Cliente(
        nome = this.nome,
        email = this.email,
        status = ClienteStatus.ATIVO
    )
}

fun ClienteAtualizacaoDto.paraModelo(valorAnterior: Cliente): Cliente {
    return Cliente(
        id = valorAnterior.id,
        nome = this.nome,
        email = this.email,
        status = valorAnterior.status
    )
}

fun LivroRequisicaoDto.paraModelo(cliente: Cliente): Livro {
    return Livro(
        nome = this.nome,
        valor = this.valor,
        status = LivroStatus.ATIVO,
        cliente = cliente
    )
}

fun LivroAtualizacaoDto.paraModelo(valorAnterior: Livro): Livro {
    return Livro(
        id = valorAnterior.id,
        nome = this.nome ?: valorAnterior.nome,
        valor = this.valor ?: valorAnterior.valor,
        status = valorAnterior.status,
        cliente = valorAnterior.cliente
    )
}

fun Cliente.paraResposta(): ClienteResposta {
    return ClienteResposta(
        id = this.id,
        nome = this.nome,
        email = this.email,
        status = this.status
    )
}

fun Livro.paraResposta(): LivroResposta {
    return LivroResposta(
        id = this.id,
        nome = this.nome,
        valor = this.valor,
        cliente = this.cliente,
        status = this.status
    )
}