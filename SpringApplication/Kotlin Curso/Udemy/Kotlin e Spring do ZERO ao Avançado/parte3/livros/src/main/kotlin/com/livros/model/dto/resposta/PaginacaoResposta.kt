package com.livros.model.dto.resposta

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.springframework.data.domain.Page

@JsonPropertyOrder("number", "size", "totalElements", "totalPages")
data class PaginacaoResposta<T>(
    val content: List<T>,
    val number: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int
) {
    companion object {
        fun <T : Any> fromPage(page: Page<T>): PaginacaoResposta<T> {
            return PaginacaoResposta(
                content = page.content,
                number = page.number,
                size = page.size,
                totalElements = page.totalElements,
                totalPages = page.totalPages
            )
        }
    }
}