// Nova interface desejada
interface Notificador {
    fun enviar(mensagem: String)
}

// Sistema antigo de email
class SistemaEmailLegado {
    fun enviarEmail(destinatario: String, assunto: String, corpo: String) {
        println("EMAIL para $destinatario")
        println("Assunto: $assunto")
        println("Corpo: $corpo")
    }
}

// Adapter
class EmailAdapter(
    private val sistemaEmail: SistemaEmailLegado,
    private val emailPadrao: String = "contato@sistema.com"
) : Notificador {
    
    override fun enviar(mensagem: String) {
        // Adapta a chamada simples para a complexa
        sistemaEmail.enviarEmail(
            destinatario = emailPadrao,
            assunto = "Notificação do Sistema",
            corpo = mensagem
        )
    }
}

// Uso
fun main() {
    val emailLegado = SistemaEmailLegado()
    val notificador = EmailAdapter(emailLegado)
    
    // Agora uso a interface simples
    notificador.enviar("Olá, sistema atualizado com sucesso!")
    
    // Saída:
    // EMAIL para contato@sistema.com
    // Assunto: Notificação do Sistema
    // Corpo: Olá, sistema atualizado com sucesso!
}