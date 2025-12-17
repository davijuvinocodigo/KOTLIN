/**
 * Nulidade no Kotlin.
 *
 * @see [Null Safety](https://play.kotlinlang.org/byExample/01_introduction/04_Null%20Safety)
 */

fun main() {

    var neverNull: String = "This can't be null"            // 1 tipo String não pode receber valor nulo
    //neverNull = null                                      // 2 descomente esta linha para ver o erro de compilação
    
    var nullable: String? = "You can keep a null here"      // 3 tipo String? pode receber valor nulo
    nullable = null                                         // 4 isto é válido
    
    var inferredNonNull = "The compiler assumes non-null"   // 5 tipo inferido como String (não nulo)
    //inferredNonNull = null                                // 6 descomente esta linha para ver o erro de compilação
    
    fun strLength(str: String?): Int {                      // 7 função que recebe uma String nula com retorno Int
        return str?.length ?: 0                             // aqui usamos safe call e elvis operator e fazemos o um acesso seguro na variável nula caso ela seja nula
    }
    
    println(strLength(neverNull))                           // 8  retorna 23
    println(strLength(nullable))                            // 9  retorna 0 pois nullable é nulo
    println(strLength(inferredNonNull))                     // 10  retorna 29 

}