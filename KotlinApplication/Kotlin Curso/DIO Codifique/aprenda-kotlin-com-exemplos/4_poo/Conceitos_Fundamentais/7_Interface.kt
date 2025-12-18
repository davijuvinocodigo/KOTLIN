/**
    Conceito de Interface em Kotlin:
    Uma interface em Kotlin é um contrato que define um conjunto de métodos e propriedades que uma classe deve implementar. 
    Diferente das classes abstratas, as interfaces não podem manter estado (variáveis de instância), mas podem conter implementações padrão para métodos. 
    As interfaces permitem a implementação de múltiplas heranças, ou seja, uma classe pode implementar várias interfaces.
*/


interface Imprimivel {
    fun imprimir()  // Método sem implementação
}

interface Digitalizavel {
    fun digitalizar()
    fun status(): String {  // Método com implementação padrão
        return "Dispositivo pronto"
    }
}

// Múltiplas interfaces
class Multifuncional : Imprimivel, Digitalizavel {
    override fun imprimir() {
        println("Imprimindo documento...")
    }
    
    override fun digitalizar() {
        println("Digitalizando documento...")
    }
    
    override fun status(): String {
        return "Multifuncional - ${super<Digitalizavel>.status()}"
    }
}

fun main() {
    val dispositivo = Multifuncional()
    dispositivo.imprimir()
    dispositivo.digitalizar()
    println(dispositivo.status())
}