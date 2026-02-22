package com.livros.excecao


import com.livros.model.dto.resposta.ErroResposta
import com.livros.model.dto.resposta.ErroCampoResposta
import com.livros.model.enums.Erros
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ManipuladorExcecoes {

    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(NaoEncontradoException::class)
    fun manipularNaoEncontrado(ex: NaoEncontradoException, request: WebRequest): ResponseEntity<ErroResposta> {
        logger.warn("Recurso não encontrado: {}", ex.message)
        val erro = ErroResposta(
            codigoHttp = HttpStatus.NOT_FOUND.value(),
            mensagem = ex.message ?: "Recurso não encontrado",
            codigoInterno = ex.codigoErro,
            erros = null
        )
        return ResponseEntity(erro, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(RequisicaoInvalidaException::class)
    fun manipularRequisicaoInvalida(ex: RequisicaoInvalidaException, request: WebRequest): ResponseEntity<ErroResposta> {
        logger.warn("Requisição inválida: {}", ex.message)
        val erro = ErroResposta(
            codigoHttp = HttpStatus.BAD_REQUEST.value(),
            mensagem = ex.message ?: "Requisição inválida",
            codigoInterno = ex.codigoErro,
            erros = null
        )
        return ResponseEntity(erro, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun manipularArgumentoInvalido(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErroResposta> {
        logger.info("Validação falhou: {}", ex.bindingResult)
        val erro = ErroResposta(
            codigoHttp = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            mensagem = Erros.VL001.mensagem,
            codigoInterno = Erros.VL001.codigo,
            erros = ex.bindingResult.fieldErrors.map {
                ErroCampoResposta(
                    mensagem = it.defaultMessage ?: "Campo inválido",
                    campo = it.field
                )
            }
        )
        return ResponseEntity(erro, HttpStatus.UNPROCESSABLE_ENTITY)
    }

    @ExceptionHandler(Exception::class)
    fun manipularExcecaoGenerica(ex: Exception, request: WebRequest): ResponseEntity<ErroResposta> {
        logger.error("Erro interno no servidor", ex)
        val erro = ErroResposta(
            codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            mensagem = "Erro interno no servidor",
            codigoInterno = "SRV001",
            erros = null
        )
        return ResponseEntity(erro, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}