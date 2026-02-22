package com.livros.model.dto.response


data class ErroResposta(
    var codigoHttp: Int,
    var mensagem: String,
    var codigoInterno: String,
    var erros: List<ErroCampoResposta>?
)