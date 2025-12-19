/**
    Conceito de Polimorfismo em Kotlin:
    O polimorfismo é um dos pilares da programação orientada a objetos que permite que objetos de diferentes classes sejam tratados como objetos de uma classe comum. 
    O polimorfismo permite que o mesmo método se comporte de maneira diferente com base no objeto que o invoca. 
    Em Kotlin, o polimorfismo é frequentemente implementado através de herança e sobrescrita de métodos.
*/


open class Forma {
    open fun calcularArea(): Double {
        return 0.0
    }
}

class Retangulo(val largura: Double, val altura: Double) : Forma() {
    override fun calcularArea(): Double {
        return largura * altura
    }
}

class Circulo(val raio: Double) : Forma() {
    override fun calcularArea(): Double {
        return Math.PI * raio * raio
    }
}

fun main() {
    val formas: List<Forma> = listOf(
        Forma(),
        Retangulo(5.0, 3.0),
        Circulo(2.0)
    )
    
    formas.forEach { forma ->
        println("Área: ${forma.calcularArea()}")
        // Mesmo método, comportamentos diferentes
    }
}