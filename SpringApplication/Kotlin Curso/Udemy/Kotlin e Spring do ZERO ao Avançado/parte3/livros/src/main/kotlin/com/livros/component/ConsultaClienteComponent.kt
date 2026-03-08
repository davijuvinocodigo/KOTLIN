package com.livros.component


import com.livros.excecao.NaoEncontradoException
import com.livros.model.Cliente
import com.livros.model.enums.Mensagens
import com.livros.repository.ClienteRepository
import org.springframework.stereotype.Component

@Component
class ConsultaClienteComponent(
    private val clienteRepository: ClienteRepository
) {
    fun buscarPorId(id: Int): Cliente {
        return clienteRepository.findById(id)
            .orElseThrow {
                NaoEncontradoException(
                    Mensagens.formatar(Mensagens.CLIENTE_NAO_ENCONTRADO, id)
                )
            }
    }

    fun emailDisponivel(email: String): Boolean {
        return !clienteRepository.existsByEmail(email)
    }

    fun existePorId(id: Int): Boolean {
        return clienteRepository.existsById(id)
    }
}