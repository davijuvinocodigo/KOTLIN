
/**
    Conceito: Construtores são usados para inicializar objetos de uma classe. 
    O construtor primário é definido na declaração da classe, enquanto os construtores secundários são definidos dentro do corpo da classe.
*/


// Construtor primário
class Carro(val marca: String, val modelo: String, var ano: Int) {
    fun exibirInfo() {
        println("Carro: $marca $modelo, Ano: $ano")
    }
}

// Construtor secundário
class Animal {
    var nome: String
    var tipo: String
    
    constructor(nome: String, tipo: String) {
        this.nome = nome
        this.tipo = tipo
    }
    
    constructor(nome: String) {
        this.nome = nome
        this.tipo = "Desconhecido"
    }
}

fun main() {
    val meuCarro = Carro("Toyota", "Corolla", 2020)
    meuCarro.exibirInfo()
    
    val animal1 = Animal("Rex", "Cachorro")
    val animal2 = Animal("Mimi")
}