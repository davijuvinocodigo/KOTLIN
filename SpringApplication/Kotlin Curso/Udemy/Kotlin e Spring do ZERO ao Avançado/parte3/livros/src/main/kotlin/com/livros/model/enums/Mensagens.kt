package com.livros.model.enums

enum class Mensagens(val texto: String) {
    REQUISICAO_INVALIDA("Requisição inválida"),
    LIVRO_NAO_ENCONTRADO("Livro não encontrado"),
    LIVRO_STATUS_INVALIDO("Não é possível alterar livro com status atual"),
    LIVROS_NAO_ENCONTRADOS("Um ou mais livros não foram encontrados"),
    CLIENTE_NAO_ENCONTRADO("Cliente não encontrado"),
    EMAIL_DUPLICADO("E-mail já está em uso"),
    VALOR_INVALIDO("Valor informado é inválido"),
    CAMPO_OBRIGATORIO("Campo obrigatório não informado");

    companion object {
        fun formatar(mensagem: Mensagens, vararg args: Any?): String {
            return String.format(mensagem.texto, *args)
        }
    }
}