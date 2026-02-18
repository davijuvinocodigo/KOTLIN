package springboot_event

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

// Classe Pai Genérica
abstract class Ouvinte<T : Evento<*>> {
    abstract fun processar(evento: T)

    @EventListener
    fun handleEvent(evento: T) {
        println("👂 ${this.javaClass.simpleName} processando: ${evento.tipo}")
        processar(evento)
    }
}

// Ouvinte para Clientes
@Component
class OuvinteCliente : Ouvinte<EventoCliente>() {
    override fun processar(evento: EventoCliente) {
        with(evento.dados) {
            println("📋 Cliente processado:")
            println("   ID: $id")
            println("   Nome: $nome")
            println("   Email: $email")
        }
    }
}

// Ouvinte para Livros
@Component
class OuvinteLivro : Ouvinte<EventoLivro>() {
    override fun processar(evento: EventoLivro) {
        with(evento.dados) {
            println("📚 Livro processado:")
            println("   ISBN: $isbn")
            println("   Título: $titulo")
            println("   Autor: $autor")
            println("   Preço: R$ $preco")
        }
    }
}

// Ouvinte para Compras
@Component
class OuvinteCompra : Ouvinte<EventoCompra>() {
    override fun processar(evento: EventoCompra) {
        with(evento.dados) {
            println("🛒 Compra processada:")
            println("   ID: $id")
            println("   Cliente: $clienteId")
            println("   Livros: ${livros.size} itens")
            println("   Total: R$ $total")
        }
    }
}

// Ouvinte Genérico (processa qualquer evento)
@Component
class OuvinteLogger : Ouvinte<Evento<*>>() {
    override fun processar(evento: Evento<*>) {
        println("📝 LOG [${evento.timestamp}] - ${evento.tipo}: $evento.id")
    }
}

// Ouvinte de Notificação (processa apenas eventos específicos)
@Component
class OuvinteNotificacao {

    @EventListener
    fun handleCliente(evento: EventoCliente) {
        println("📧 Email enviado para ${evento.dados.email}")
    }

    @EventListener
    fun handleCompra(evento: EventoCompra) {
        println("📱 Push: Compra ${evento.dados.id} realizada com sucesso!")
    }
}