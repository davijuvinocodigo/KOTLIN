package springboot_event

import org.springframework.context.ApplicationEvent
import java.time.LocalDateTime
import java.util.UUID

// Classe Pai Genérica
abstract class Evento<T>(
    source: Any,
    val dados: T,
    val id: String = UUID.randomUUID().toString(),
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val tipo: String
) : ApplicationEvent(source)

// Eventos Específicos
data class Cliente(
    val id: String,
    val nome: String,
    val email: String
)

class EventoCliente(
    source: Any,
    dados: Cliente
) : Evento<Cliente>(source, dados, tipo = "CLIENTE")

data class Livro(
    val isbn: String,
    val titulo: String,
    val autor: String,
    val preco: Double
)

class EventoLivro(
    source: Any,
    dados: Livro
) : Evento<Livro>(source, dados, tipo = "LIVRO")

data class Compra(
    val id: String,
    val clienteId: String,
    val livros: List<Livro>,
    val total: Double
)

class EventoCompra(
    source: Any,
    dados: Compra
) : Evento<Compra>(source, dados, tipo = "COMPRA")