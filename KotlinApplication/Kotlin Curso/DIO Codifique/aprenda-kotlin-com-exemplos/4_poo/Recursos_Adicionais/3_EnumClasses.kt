/**
    * Conceito de Enum Classes em Kotlin:
    * Enum classes (ou classes enumeradas) são usadas para representar um conjunto fixo de constantes relacionadas.
    * Elas são úteis quando você precisa de um tipo que pode ter um número limitado de valores possíveis.
*/

enum class DiaDaSemana(val abreviacao: String) {
    SEGUNDA("Seg"),
    TERCA("Ter"),
    QUARTA("Qua"),
    QUINTA("Qui"),
    SEXTA("Sex"),
    SABADO("Sab"),
    DOMINGO("Dom");
    
    fun ehDiaUtil(): Boolean {
        return this != SABADO && this != DOMINGO
    }
}

fun main() {
    val hoje = DiaDaSemana.SEGUNDA
    
    println(hoje)                   // Saída: SEGUNDA
    println(hoje.abreviacao)        // Saída: Seg
    println(hoje.ehDiaUtil())       // Saída: true
    println(hoje.ordinal)           // Saída: 0 (posição)
    
    // Iteração
    for (dia in DiaDaSemana.values()) {
        println("${dia.name} - ${dia.abreviacao}")
    }
}