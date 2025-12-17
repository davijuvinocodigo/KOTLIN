/**
 * Lidando com valores nulos.
 *
 * @see [Null Safety](https://play.kotlinlang.org/byExample/01_introduction/04_Null%20Safety)
 */
 
fun describeString(maybeString: String?): String {              // 1 função que aceita String nula
    if (maybeString != null && maybeString.length > 0) {        // 2 verificação explícita de nulo
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"                           // 3 tratamento do caso nulo ou vazio
    }
}

fun main() {
    println(describeString(null))
    println(describeString(""))
    println(describeString("dio.me"))
}