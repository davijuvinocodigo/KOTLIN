package com.livros.service


import com.livros.model.enums.ClienteStatus
import com.livros.model.enums.Errors
import com.livros.exception.NotFoundException
import com.livros.model.Cliente
import com.livros.repository.ClienteRepository
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class ClienteService(
    val clienteRepository: ClienteRepository,
    val livroService: LivroService
) {

    fun getAll(name: String?): List<Cliente> {
        name?.let {
            return clienteRepository.findByNomeContaining(it)
        }
        return clienteRepository.findAll().toList()
    }

    fun create(customer: Cliente) {
        clienteRepository.save(customer)
    }

    fun findById(id: Int): Cliente {
        return clienteRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code) }
    }

    fun update(customer: Cliente) {
        if(!clienteRepository.existsById(customer.id!!)){
            throw Exception()
        }

        clienteRepository.save(customer)
    }

    fun delete(id: Int) {
        val customer = findById(id)
        livroService.deleteByCustomer(customer)

        customer.status = ClienteStatus.INATIVO

        clienteRepository.save(customer)
    }

    fun emailAvailable(email: String): Boolean {
        return !clienteRepository.existsByEmail(email)
    }

}