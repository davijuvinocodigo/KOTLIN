/**
 * Iterators. Lista de números inteiros.
 *
 * @see [Loops]
    * Obtenção do iterador: val iterator = numbers.iterator() obtém um iterador para a lista, que permite percorrer os elementos um por um.
 */

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    val iterator = numbers.iterator()
    while (iterator.hasNext()) {
        val number = iterator.next()
        println(number)
    }
}



/**
    Iterators Objeto
    * @see [Loops]
      * Definição da classe Zoo: A classe Zoo contém uma lista de objetos Animal e define um método iterator() que retorna um iterador para essa lista.
      * O uso da assinatura operator fun iterator(): Iterator<Animal> permite que a classe Zoo seja iterada diretamente em um loop for.
*/

class Animal(val name: String)  

class Zoo(val animals: List<Animal>) {
    operator fun iterator(): Iterator<Animal> {
        return animals.iterator()
    }
}

fun main() {

    val animals = listOf(Animal("Leão"), Animal("Tigre"), Animal("Urso"))
    val zoo = Zoo(animals)
    val zoo = Zoo()

    for (animal in zoo) {
        println("Saida do animal ${animal.name}")
    }
}

