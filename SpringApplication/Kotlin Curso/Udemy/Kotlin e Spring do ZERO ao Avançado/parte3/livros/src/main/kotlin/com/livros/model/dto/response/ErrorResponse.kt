package com.livros.model.dto.response

data class ErrorRESP(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var errors: List<FieldErrorRESP>?
)