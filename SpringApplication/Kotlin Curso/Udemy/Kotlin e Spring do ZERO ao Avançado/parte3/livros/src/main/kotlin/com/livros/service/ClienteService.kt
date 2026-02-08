package com.livros.service


import com.livros.model.enums.ClienteStatus
import com.livros.model.enums.Errors
import com.livros.exception.NotFoundException
import com.livros.model.Cliente
import com.livros.repository.ClienteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClienteService(
    private val clienteRepository: ClienteRepository,
    private val livroService: LivroService
) {

    fun buscarTodos(nome: String?): List<Cliente> =
        nome?.let { clienteRepository.findByNomeContaining(it) } ?: clienteRepository.findAll().toList()

    fun criar(cliente: Cliente) = clienteRepository.save(cliente)

    fun buscarPorId(id: Int): Cliente =
        clienteRepository.findById(id)
            .orElseThrow { NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code) }

    fun atualizar(cliente: Cliente) {
        val id = cliente.id ?: throw IllegalArgumentException("Id do cliente não pode ser nulo")
        if (!clienteRepository.existsById(id)) {
            throw NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code)
        }
        clienteRepository.save(cliente)
    }

    @Transactional
    fun excluir(id: Int) {
        val cliente = buscarPorId(id)
        livroService.excluirPorCliente(cliente)
        cliente.status = ClienteStatus.INATIVO
        clienteRepository.save(cliente)
    }

    fun emailAvailable(email: String): Boolean = !clienteRepository.existsByEmail(email)
}