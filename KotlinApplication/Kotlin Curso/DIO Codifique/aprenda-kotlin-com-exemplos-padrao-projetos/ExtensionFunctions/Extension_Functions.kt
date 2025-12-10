/**
    Extension Functions em Kotlin
    Extension functions são uma funcionalidade poderosa do Kotlin que permite adicionar novas funcionalidades a
    classes existentes sem precisar herdar delas ou usar padrões como Decorator.

    O que são Extension Functions?
    Extension functions são funções que "estendem" uma classe com novas funcionalidades. 
    A sintaxe é similar a funções normais, mas com um receiver type (o tipo que está sendo estendido) precedendo o nome da função.

*/

/*
    Sintaxe Básica
    A sintaxe para declarar uma extension function é a seguinte:

*/

fun ClasseQueSeraEstendida.novaFuncao(parametros): TipoRetorno {
    // corpo da função
    // 'this' se refere ao objeto recebido
}



// Exemplo 1: Extensão para String
fun String.inverter(): String {
    return this.reversed()
}

fun main() {
    val texto = "Kotlin"
    println(texto.inverter()) // Saída: niltoK
    
    // Também pode ser chamado como função normal
    println("Hello".inverter()) // Saída: olleH
}