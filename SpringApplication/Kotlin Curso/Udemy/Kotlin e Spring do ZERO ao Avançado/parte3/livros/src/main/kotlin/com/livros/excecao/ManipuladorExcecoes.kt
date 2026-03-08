package com.livros.excecao

import com.livros.model.dto.resposta.ErroResposta
import com.livros.model.dto.resposta.ErroCampoResposta
import com.livros.model.enums.Mensagens
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ManipuladorExcecoes {

    @ExceptionHandler(NaoEncontradoException::class)
    fun manipularNaoEncontrado(ex: NaoEncontradoException, request: WebRequest): ResponseEntity<ErroResposta> {
        val erro = ErroResposta(
            codigoHttp = HttpStatus.NOT_FOUND.value(),
            mensagem = ex.message ?: Mensagens.REQUISICAO_INVALIDA.texto,
            erros = null
        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(RequisicaoInvalidaException::class)
    fun manipularRequisicaoInvalida(ex: RequisicaoInvalidaException, request: WebRequest): ResponseEntity<ErroResposta> {
        val erro = ErroResposta(
            codigoHttp = HttpStatus.BAD_REQUEST.value(),
            mensagem = ex.message ?: Mensagens.REQUISICAO_INVALIDA.texto,
            erros = null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun manipularArgumentoInvalido(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErroResposta> {
        val erro = ErroResposta(
            codigoHttp = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            mensagem = Mensagens.REQUISICAO_INVALIDA.texto,
            erros = ex.bindingResult.fieldErrors.map {
                ErroCampoResposta(
                    mensagem = it.defaultMessage ?: Mensagens.CAMPO_OBRIGATORIO.texto,
                    campo = it.field
                )
            }
        )
        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}