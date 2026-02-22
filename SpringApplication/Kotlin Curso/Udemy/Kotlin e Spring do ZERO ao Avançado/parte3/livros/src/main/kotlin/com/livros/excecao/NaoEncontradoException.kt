package com.livros.excecao

class NaoEncontradoException(override val message: String, val codigoErro: String) : Exception()
