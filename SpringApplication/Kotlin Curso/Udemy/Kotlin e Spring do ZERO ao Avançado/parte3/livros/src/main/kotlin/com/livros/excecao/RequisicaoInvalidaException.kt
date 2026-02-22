package com.livros.excecao

class RequisicaoInvalidaException(override val message: String, val codigoErro: String) : Exception()