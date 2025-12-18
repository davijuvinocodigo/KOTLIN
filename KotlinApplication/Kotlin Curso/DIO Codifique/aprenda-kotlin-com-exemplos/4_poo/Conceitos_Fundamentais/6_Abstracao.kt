/**
    Conceito de Abstração em Kotlin:
    A abstração é um dos pilares da programação orientada a objetos que permite simplificar sistemas complexos, 
    focando apenas nos aspectos essenciais e ignorando os detalhes desnecessários. 
    Em Kotlin, a abstração pode ser implementada através de classes abstratas e interfaces.
*/


// Classe abstrata - não pode ser instanciada diretamente
abstract class Funcionario(val nome: String, val salarioBase: Double) {
    abstract fun calcularSalario(): Double  // Método abstrato
    
    fun exibirInfo() {
        println("Nome: $nome, Salário: ${calcularSalario()}")
    }
}

class Desenvolvedor(nome: String, salarioBase: Double, val bonus: Double) 
    : Funcionario(nome, salarioBase) {
    
    override fun calcularSalario(): Double {
        return salarioBase + bonus
    }
}

class Gerente(nome: String, salarioBase: Double, val comissao: Double) 
    : Funcionario(nome, salarioBase) {
    
    override fun calcularSalario(): Double {
        return salarioBase + (salarioBase * comissao)
    }
}

fun main() {
    val dev = Desenvolvedor("Ana", 5000.0, 1000.0)
    val gerente = Gerente("Carlos", 7000.0, 0.2)
    
    dev.exibirInfo()
    gerente.exibirInfo()
}