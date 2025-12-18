/**
    Conceito de Herança em Kotlin:
    A herança é um dos pilares da programação orientada a objetos que permite que uma classe (subclasse) herde propriedades e comportamentos 
    (atributos e métodos) de outra classe (superclasse). Isso promove a reutilização de código e estabelece uma relação hierárquica entre classes.
    
    Em Kotlin, para permitir que uma classe seja herdada, ela deve ser declarada com a palavra-chave 'open'. 
    Da mesma forma, métodos que podem ser sobrescritos em subclasses também devem ser marcados como 'open'. 
    A palavra-chave 'override' é usada na subclasse para indicar que um método está sendo sobrescrito.
*/



// Classe pai/superclasse
open class Veiculo(val marca: String, val modelo: String) {
    open fun acelerar() {
        println("O veículo está acelerando...")
    }
    
    fun frear() {
        println("O veículo está freando...")
    }
}

// Classe filha/subclasse
class CarroEsportivo(marca: String, modelo: String, val turbo: Boolean) 
    : Veiculo(marca, modelo) {
    
    override fun acelerar() {
        if (turbo) {
            println("VRUMMMM! Turbo ativado!")
        } else {
            super.acelerar()  // Chama o método da classe pai
        }
    }
}

fun main() {
    val veiculo = Veiculo("Ford", "Fiesta")
    val esportivo = CarroEsportivo("Ferrari", "F8", true)
    
    veiculo.acelerar()      // Saída: O veículo está acelerando...
    esportivo.acelerar()    // Saída: VRUMMMM! Turbo ativado!
    esportivo.frear()       // Herdado da classe pai
}
