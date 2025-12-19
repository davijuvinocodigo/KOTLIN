??/**
    Conceito de Encapsulamento em Kotlin:
    O encapsulamento é um dos pilares da programação orientada a objetos. Ele consiste em proteger os dados de uma classe, 
    restringindo o acesso direto a seus atributos e métodos. Isso é feito declarando atributos como privados (usando a palavra-chave 'private') 
    e fornecendo métodos públicos (getters e setters) para acessar e modificar esses atributos de forma controlada.

*/



class ContaBancaria {
    private var saldo: Double = 0.0  // Atributo privado
    
    fun depositar(valor: Double) {
        if (valor > 0) {
            saldo += valor
            println("Depósito de R$$valor realizado.")
        }
    }
    
    fun sacar(valor: Double): Boolean {
        if (valor <= saldo) {
            saldo -= valor
            println("Saque de R$$valor realizado.")
            return true
        }
        println("Saldo insuficiente.")
        return false
    }
    
    fun consultarSaldo(): Double {
        return saldo
    }
}

fun main() {
    val conta = ContaBancaria()
    conta.depositar(1000.0)
    conta.sacar(300.0)
    println("Saldo atual: R$${conta.consultarSaldo()}")
    // conta.saldo = 5000.0  // ERRO: saldo é privado!
}