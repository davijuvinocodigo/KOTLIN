package com.livros.excecao

class NotFoundException(override val message: String, val errorCode: String) : Exception() {
}