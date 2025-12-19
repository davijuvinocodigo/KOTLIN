/**
 * Enum tradicional.
 *
 * @see [Enum Classes]
 * Conceito do exemplo abaixo:
    * - Definição de um enum simples com três estados.
    * - Uso do enum em uma expressão `when` para determinar o estado atual.
 */

enum class Estado {
    OCIOSO, INICIADO, TERMINADO                           
}

fun main() {
    val estado = Estado.INICIADO                         
    val mensagem = when (estado) {                      
        Estado.OCIOSO -> "Está ocioso"
        Estado.INICIADO -> "Está iniciado"
        Estado.TERMINADO -> "Está terminado"
    }
    println(mensagem)
}









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









/**
 * Enum podem ter propriedades e métodos.
 *
 * @see [Enum Classes]
    * Conceito do exemplo abaixo:
        * - Definição de um enum com propriedades.
        * - Adição de um método ao enum para verificar uma condição baseada na propriedade.
        
 */

enum class Color(val rgb: Int) {                      
    RED(0xFF0000),                                    
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)  
}

fun main() {
    val red = Color.RED
    println(red)                                      
    println(red.containsRed())                        
    println(Color.BLUE.containsRed())                 
    println(Color.YELLOW.containsRed())               
}