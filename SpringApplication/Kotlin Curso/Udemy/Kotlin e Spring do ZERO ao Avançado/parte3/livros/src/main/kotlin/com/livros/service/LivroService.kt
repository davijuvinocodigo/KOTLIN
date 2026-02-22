package com.livros.service

import com.livros.excecao.NaoEncontradoException
import com.livros.excecao.RequisicaoInvalidaException
import com.livros.model.dto.LivroAtualizacaoDto
import com.livros.model.dto.LivroRequisicaoDto
import com.livros.model.enums.Erros
import com.livros.model.enums.LivroStatus
import com.livros.extensao.paraModelo
import com.livros.model.Cliente
import com.livros.model.Livro
import com.livros.repository.LivroRepository
import com.livros.repository.ClienteRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LivroService(
    private val livroRepository: LivroRepository,
    private val clienteRepository: ClienteRepository
) {

    fun criar(requisicao: LivroRequisicaoDto): Livro {
        val cliente = clienteRepository.findById(requisicao.clienteId)
            .orElseThrow { NaoEncontradoException(Erros.CL001.mensagem.format(requisicao.clienteId), Erros.CL001.codigo) }
        val livro = requisicao.paraModelo(cliente)
        return livroRepository.save(livro)
    }

    fun buscarTodos(paginacao: Pageable): Page<Livro> {
        return livroRepository.findAll(paginacao)
    }

    fun buscarAtivos(paginacao: Pageable): Page<Livro> {
        return livroRepository.findByStatus(LivroStatus.ATIVO, paginacao)
    }

    fun buscarPorId(id: Int): Livro {
        return livroRepository.findById(id)
            .orElseThrow { NaoEncontradoException(Erros.LV001.mensagem.format(id), Erros.LV001.codigo) }
    }

    @Transactional
    fun excluir(id: Int) {
        val livro = buscarPorId(id)
        validarAlteracaoStatus(livro)
        livro.status = LivroStatus.CANCELADO
    }

    @Transactional
    fun atualizar(id: Int, requisicao: LivroAtualizacaoDto) {
        val livroExistente = buscarPorId(id)
        validarAlteracaoStatus(livroExistente)
        val livroAtualizado = requisicao.paraModelo(livroExistente)
        livroRepository.save(livroAtualizado)
    }

    @Transactional
    fun excluirPorCliente(cliente: Cliente) {
        val livros = livroRepository.findByCliente(cliente)
        livros.forEach {
            validarAlteracaoStatus(it)
            it.status = LivroStatus.DELETADO
        }
    }

    fun buscarTodosPorIds(livroIds: Set<Int>): List<Livro> {
        val livros = livroRepository.findAllById(livroIds)

        if (livros.size != livroIds.size) {
            val idsEncontrados = livros.map { it.id }.toSet()
            val idsNaoEncontrados = livroIds - idsEncontrados
            throw NaoEncontradoException(
                Erros.LV003.mensagem.format(idsNaoEncontrados.joinToString()),
                Erros.LV003.codigo
            )
        }

        return livros
    }

    @Transactional
    fun comprar(livros: MutableList<Livro>) {
        livros.forEach {
            validarAlteracaoStatus(it)
            it.status = LivroStatus.VENDIDO
        }
    }

    private fun validarAlteracaoStatus(livro: Livro) {
        if (livro.status == LivroStatus.CANCELADO || livro.status == LivroStatus.DELETADO) {
            throw RequisicaoInvalidaException(
                Erros.LV002.mensagem.format(livro.status),
                Erros.LV002.codigo
            )
        }
    }
}