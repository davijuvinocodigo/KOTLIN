/**
 * Funções de Escopo: [also].
 *
 * @see [also]
 * Executa um bloco de código no objeto e retorna o próprio objeto. Útil para ações de side-effect.
 */

fun exemploAlso() {
    val lista = mutableListOf(1, 2, 3)
    
    val novaLista = lista.also {
        println("Lista original: $it")
        it.add(4) // Modifica a lista
        println("Lista modificada: $it")
    }
    
    println("Mesma referência: ${lista === novaLista}") // true
    println("Lista final: $lista") // [1, 2, 3, 4]
    
    // Configuração de objetos
    val pessoa = Pessoa().also {
        it.nome = "Maria"
        it.idade = 30
        it.endereco = "Rua A, 123"
    }
}