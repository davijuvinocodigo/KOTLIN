package com.livros.model.enums

enum class Erros(val codigo: String, val mensagem: String) {
    VL001("VL-001", "Requisição inválida"),
    LV001("LV-001", "Livro [%s] não encontrado"),
    LV002("LV-002", "Não é possível alterar livro com status [%s]"),
    LV003("LV-003", "Livros com IDs [%s] não encontrados"),
    CL001("CL-001", "Cliente [%s] não encontrado")
}