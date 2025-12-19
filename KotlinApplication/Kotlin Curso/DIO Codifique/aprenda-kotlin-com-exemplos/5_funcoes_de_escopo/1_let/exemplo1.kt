/**
 * Funções de Escopo: [let].
 *
 * @see [let]
    *   Função: Retorna o resultado da lambda
        Referência: it (ou nome personalizado)
        Uso: Transformar valores e tratar nullables
 */

fun exemploLet() {
    val nome: String? = "João"
    
    // Uso básico
    val resultado = nome?.let {
        println("Nome: $it") // 'it' refere-se ao objeto
        it.length          // Retorna o comprimento
    }
    println("Comprimento: $resultado") // 4
    
    // Com múltiplas operações
    val numero: Int? = 10
    numero?.let {
        val quadrado = it * it
        println("O quadrado de $it é $quadrado")
    }
    
    // Renomeando 'it'
    nome?.let { nomeNaoNulo ->
        println("Nome não nulo: $nomeNaoNulo")
    }
}