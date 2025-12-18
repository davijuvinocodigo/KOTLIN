/**
    Conceito: Classes são "plantas" que definem atributos e comportamentos, enquanto objetos são instâncias concretas dessas classes.
*/


// Classe é a definição
class Pessoa {
    var nome: String = ""
    var idade: Int = 0
    
    fun apresentar() {
        println("Olá, meu nome é $nome e tenho $idade anos.")
    }
}

// Objeto é uma instância da classe
fun main() {
    val pessoa1 = Pessoa()
    pessoa1.nome = "João"
    pessoa1.idade = 25
    pessoa1.apresentar() // Saída: Olá, meu nome é João e tenho 25 anos.
}