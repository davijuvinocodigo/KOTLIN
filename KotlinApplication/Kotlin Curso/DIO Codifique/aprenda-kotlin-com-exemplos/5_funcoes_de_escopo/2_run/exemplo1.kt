/**
 * Funções de Escopo: [run].
 *
 * @see [run]
        *   Função: Executa lambda e retorna seu resultado
            Referência: this (dentro do escopo)
            Uso: Inicializar objetos e calcular valores
 */

// Como função de extensão
val pessoa = Pessoa("João", 25)
val descricao = pessoa.run {
    // 'this' refere-se a 'pessoa'
    "Nome: $nome, Idade: $idade"
}
println(descricao) // "Nome: João, Idade: 25"

// Forma não-extension (contexto isolado)
val resultado = run {
    val x = 5
    val y = 3
    x + y  // Retorna 8
}
println(resultado) // 8