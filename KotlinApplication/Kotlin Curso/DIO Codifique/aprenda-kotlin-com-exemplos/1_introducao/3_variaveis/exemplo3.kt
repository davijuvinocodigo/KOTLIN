/**
 * Variáveis: [var] e [val].
 *
 * @see [Variables](https://play.kotlinlang.org/byExample/01_introduction/03_Variables)
 */

fun someCondition() = true 

fun main() {

    val d: Int  // 1
    
    if (someCondition()) {
        d = 1   // 2  variável inicializada 
    } else {
        d = 2   // 2  ou inicializada aqui
    }
    
    println(d) // 3 

}