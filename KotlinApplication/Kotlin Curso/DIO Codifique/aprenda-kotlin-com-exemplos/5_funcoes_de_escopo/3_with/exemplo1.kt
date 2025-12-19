/**
 * Funções de Escopo: [with].
 *
 * @see [with]
 * Executa um bloco de código no contexto de um objeto sem precisar usar it ou this.
        *   Função: Similar ao run, mas não é função de extensão
            Referência: this
            Uso: Agrupar operações em um objeto
 */

fun exemploWith() {
    val lista = listOf("a", "b", "c")
    
    val resultado = with(lista) {
        println("Tamanho: $size")
        println("Primeiro: ${first()}")
        println("Último: ${last()}")
        joinToString(", ") // Última expressão é retornada
    }
    
    println("Resultado: $resultado") // "a, b, c"
    
    // Configurando objetos
    data class Config(val host: String, val porta: Int, val ssl: Boolean)
    
    val config = Config("localhost", 8080, false)
    
    with(config) {
        println("Servidor: $host:$porta")
        println("SSL habilitado: $ssl")
    }
}