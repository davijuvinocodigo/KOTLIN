/**
    Conceito de Herança em Kotlin:
    A herança é um dos pilares da programação orientada a objetos que permite que uma classe (subclasse) herde propriedades e comportamentos 
    (atributos e métodos) de outra classe (superclasse). Isso promove a reutilização de código e estabelece uma relação hierárquica entre classes.
    
    Em Kotlin, para permitir que uma classe seja herdada, ela deve ser declarada com a palavra-chave 'open'. 
    Da mesma forma, métodos que podem ser sobrescritos em subclasses também devem ser marcados como 'open'. 
    A palavra-chave 'override' é usada na subclasse para indicar que um método está sendo sobrescrito.

    Porque por padrão as classes e métodos em Kotlin são 'final' isso quer dizer que estão encapsuladas, ou seja, não podem ser herdados ou sobrescritos a menos que sejam explicitamente marcados como 'open'.
*/



/**
    Exemplo 1
    Classe pai/superclasse: Cachorro
    Classes filhas/subclasses: pitbull, Yorkshire, Poodle
*/ 

open class Cachorro {                
    open fun latindo() {       
        println("wow wow!")
    }
}

// Classe filha/subclasse
class pitbull : Cachorro() {       

}

// Classe filha/subclasse
class Poodle : Cachorro() {       
    override fun latindo() {   
        println("auuu auuu!!")
    }
}

fun main() {
    val cachorro1: Cachorro = pitbull()
    val cachorro2: Cachorro = Poodle()

    cachorro1.latindo()
    cachorro2.latindo()
}









/**
    Exemplo 2: com parâmetros no construtor
    Classe pai/superclasse: Cachorro
    Classes filhas/subclasses: pitbull, Yorkshire, Poodle

    A classe Cachorro é declarada como open, permitindo herança. Ela tem um construtor com parâmetros nome e raca, e um método latindo() que imprime uma mensagem padrão.
    A subclasse pitbull herda de Cachorro com valores fixos ("Rex", "Pitbull") e não sobrescreve o método latindo().
    A subclasse Poodle herda de Cachorro passando parâmetros via construtor e sobrescreve latindo() com uma mensagem diferente (usando override).
*/

open class Cachorro(val nome: String, val raca: String) {                
    open fun latindo() {       
        println("$nome $raca wow wow!")
    }
}

// Classe filha/subclasse
class pitbull : Cachorro("Rex", "Pitbull") {       

}

// Classe filha/subclasse
class Poodle(nome: String, raca: String) : Cachorro(nome, raca) {       
    override fun latindo() {   
        println("$nome $raca auuu auuu!!")
    }
}

fun main() {
    val cachorro1: Cachorro = pitbull()
    val cachorro2: Cachorro = Poodle("Bella", "Poodle")

    cachorro1.latindo()
    cachorro2.latindo()
}





