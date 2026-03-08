package com.livros.service

import com.livros.component.ConsultaClienteComponent
import com.livros.eventos.AuditoriaCliente
import com.livros.eventos.publicador.PublicadorSincrono
import com.livros.model.dto.ClienteAtualizacaoDto
import com.livros.model.dto.ClienteRequisicaoDto
import com.livros.model.enums.ClienteStatus
import com.livros.extensao.paraModelo
import com.livros.model.Cliente
import com.livros.repository.ClienteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository,
    private val consultaClienteComponent: ConsultaClienteComponent,
    private val livroService: LivroService,
    private val publicadorEvento: PublicadorSincrono<AuditoriaCliente>
) {

    fun buscarTodos(nome: String?): List<Cliente> {
        return nome?.let { clienteRepository.findByNomeContaining(it) }
            ?: clienteRepository.findAll().toList()
    }

    fun criar(requisicao: ClienteRequisicaoDto): Cliente {
        val cliente = requisicao.paraModelo()
        val clienteSalvo = clienteRepository.save(cliente)

        publicadorEvento.publicar(AuditoriaCliente(this, clienteSalvo))
        return clienteSalvo
    }

    fun buscarPorId(id: Int): Cliente {
        return consultaClienteComponent.buscarPorId(id)
    }

    @Transactional
    fun atualizar(id: Int, requisicao: ClienteAtualizacaoDto) {
        val clienteExistente = buscarPorId(id)
        val clienteAtualizado = requisicao.paraModelo(clienteExistente)
        clienteRepository.save(clienteAtualizado)
    }

    @Transactional
    fun excluir(id: Int) {
        val cliente = buscarPorId(id)
        livroService.excluirPorCliente(cliente)
        cliente.status = ClienteStatus.INATIVO
        clienteRepository.save(cliente)
    }

    fun emailDisponivel(email: String): Boolean {
        return consultaClienteComponent.emailDisponivel(email)
    }
}