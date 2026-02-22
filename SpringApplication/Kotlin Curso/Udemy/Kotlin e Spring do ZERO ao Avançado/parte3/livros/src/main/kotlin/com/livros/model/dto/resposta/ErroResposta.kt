package com.livros.model.dto.resposta


data class ErroResposta(
    var codigoHttp: Int,
    var mensagem: String,
    var codigoInterno: String,
    var erros: List<ErroCampoResposta>?
)