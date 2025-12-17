/**
 * Listas.
 * Uma List em Kotlin é uma coleção ordenada de elementos e pode conter duplicatas. 
   Ela é imutável por padrão, o que significa que, uma vez criada, a lista não pode ser alterada.
 
 * @see [List]
 */

fun main() {
    listImutaveis()
    listMutaveis()
}    




fun listImutaveis() {
    // Listas imutáveis
    val cores: List<String> = listOf("Vermelho", "Verde", "Azul")

    println(cores)                 // Imprime a lista completa
    println(cores[1])              // Acessa o segundo elemento
    println(cores.size)            // Tamanho da lista
    println(cores.contains("Amarelo")) // Verifica se o elemento "Amarelo" está na lista
    println(cores.indexOf("Azul")) // Índice do elemento "Azul"
}



fun listMutaveis() {
    // Listas mutáveis
    val frutas: MutableList<String> = mutableListOf("Maçã", "Banana", "Laranja")

    frutas.add("Uva")              // Adiciona um elemento
    frutas.remove("Banana")        // Remove um elemento

    println(frutas)                // Imprime a lista atualizada
}



