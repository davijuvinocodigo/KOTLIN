package springboot_event

import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/livraria")
class LivrariaController(
    private val publicadorSincrono: PublicadorSincrono<Evento<*>>,
    private val publicadorAssincrono: PublicadorAssincrono<Evento<*>>
) {

    @PostMapping("/clientes")
    fun criarCliente(@RequestBody request: ClienteRequest): String {
        val cliente = Cliente(
            id = UUID.randomUUID().toString(),
            nome = request.nome,
            email = request.email
        )

        val evento = EventoCliente(this, cliente)
        publicadorSincrono.publicar(evento)

        return "Cliente ${cliente.nome} cadastrado com sucesso!"
    }

    @PostMapping("/livros")
    fun adicionarLivro(@RequestBody request: LivroRequest): String {
        val livro = Livro(
            isbn = request.isbn,
            titulo = request.titulo,
            autor = request.autor,
            preco = request.preco
        )

        val evento = EventoLivro(this, livro)
        publicadorSincrono.publicar(evento)

        return "Livro '${livro.titulo}' adicionado ao catálogo!"
    }

    @PostMapping("/compras")
    fun realizarCompra(@RequestBody request: CompraRequest): String {
        val livros = request.livros.map { livroReq ->
            Livro(
                isbn = livroReq.isbn,
                titulo = livroReq.titulo,
                autor = livroReq.autor,
                preco = livroReq.preco
            )
        }

        val compra = Compra(
            id = UUID.randomUUID().toString(),
            clienteId = request.clienteId,
            livros = livros,
            total = livros.sumOf { it.preco }
        )

        val evento = EventoCompra(this, compra)
        publicadorAssincrono.publicar(evento)

        return "Compra ${compra.id} realizada com sucesso! Total: R$ ${compra.total}"
    }

    @PostMapping("/completo")
    fun fluxoCompleto(): String {
        // Cliente
        val cliente = Cliente(
            id = UUID.randomUUID().toString(),
            nome = "João Leitor",
            email = "joao@email.com"
        )
        publicadorSincrono.publicar(EventoCliente(this, cliente))

        // Livros
        val livros = listOf(
            Livro("978-12345", "Kotlin para Iniciantes", "João Silva", 59.90),
            Livro("978-67890", "Spring Boot Essencial", "Maria Santos", 89.90)
        )

        livros.forEach {
            publicadorSincrono.publicar(EventoLivro(this, it))
        }

        // Compra
        val compra = Compra(
            id = UUID.randomUUID().toString(),
            clienteId = cliente.id,
            livros = livros,
            total = livros.sumOf { it.preco }
        )
        publicadorAssincrono.publicar(EventoCompra(this, compra))

        return "Fluxo completo executado!"
    }
}

// Requests
data class ClienteRequest(
    val nome: String,
    val email: String
)

data class LivroRequest(
    val isbn: String,
    val titulo: String,
    val autor: String,
    val preco: Double
)

data class LivroItemRequest(
    val isbn: String,
    val titulo: String,
    val autor: String,
    val preco: Double
)

data class CompraRequest(
    val clienteId: String,
    val livros: List<LivroItemRequest>
)