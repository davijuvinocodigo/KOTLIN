package com.livros.excecao

class BadRequestException(override val message: String, val errorCode: String) : Exception() {
}