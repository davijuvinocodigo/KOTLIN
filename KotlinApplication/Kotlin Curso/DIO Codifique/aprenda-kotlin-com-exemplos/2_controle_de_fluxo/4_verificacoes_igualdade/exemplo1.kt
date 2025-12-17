/**
 * Verificações de igualdade.
 *
 * @see [Equality Checks]
 * Comparações de igualdade em Kotlin podem ser feitas usando os operadores `==` e `===`.
    * O operador `==` verifica a igualdade estrutural (conteúdo), enquanto o operador `===` verifica a igualdade referencial (mesmo objeto na memória).
 */

fun main() {
   
   val autor = setOf("George Orwell", "Aldous Huxley", "Ray Bradbury")
   val escritor = setOf("George Orwell", "Aldous Huxley", "Ray Bradbury")

   println(autor == escritor)  // true
   println(autor === escritor) // false 

}