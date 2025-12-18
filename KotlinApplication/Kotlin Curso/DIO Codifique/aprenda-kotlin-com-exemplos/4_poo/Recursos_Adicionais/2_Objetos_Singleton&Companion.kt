/**
    * Conceitos de Singleton e Companion Object em Kotlin:

    * Singleton é um padrão de design que garante que uma classe tenha apenas uma instância e fornece um ponto global de acesso a essa instância.
    * Em Kotlin, isso pode ser facilmente implementado usando a palavra-chave `object`.

    * Companion Object é um objeto declarado dentro de uma classe usando a palavra-chave `companion`.
    * Ele permite que você defina membros que pertencem à classe em si, em vez a instâncias da classe, funcionando de maneira semelhante a membros estáticos em outras linguagens.
*/

// Singleton com object
object Configuracao {
    val versao: String = "1.0.0"
    var tema: String = "Claro"
    
    fun exibirConfig() {
        println("Versão: $versao, Tema: $tema")
    }
}

// Companion Object (objeto companheiro)
class Matematica {
    companion object {
        const val PI = 3.14159
        
        fun somar(a: Int, b: Int): Int {
            return a + b
        }
    }
}

fun main() {
    // Singleton
    Configuracao.tema = "Escuro"
    Configuracao.exibirConfig()
    
    // Companion Object
    println("PI: ${Matematica.PI}")
    println("Soma: ${Matematica.somar(5, 3)}")
}