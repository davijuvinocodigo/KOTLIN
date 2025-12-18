
/**
    * Conceito de Sealed Classes em Kotlin:
    * Sealed classes (ou classes seladas) são usadas para representar hierarquias de classes restritas.
    * Elas permitem que você defina um conjunto fixo de subclasses dentro do mesmo arquivo, 
    * o que facilita o controle sobre os tipos que podem ser usados em determinadas situações.
    * Isso é especialmente útil em combinação com expressões `when`, onde o compilador pode garantir que todos os casos sejam tratados.
*/

sealed class Resultado {
    data class Sucesso(val dados: String) : Resultado()
    data class Erro(val mensagem: String) : Resultado()
    object Carregando : Resultado()
}

fun processarResultado(resultado: Resultado) {
    when (resultado) {
        is Resultado.Sucesso -> println("Sucesso: ${resultado.dados}")
        is Resultado.Erro -> println("Erro: ${resultado.mensagem}")
        Resultado.Carregando -> println("Carregando...")
        // Não precisa de 'else' porque cobrimos todos os casos
    }
}

fun main() {
    val sucesso = Resultado.Sucesso("Dados carregados")
    val erro = Resultado.Erro("Falha na conexão")
    
    processarResultado(sucesso)
    processarResultado(erro)
    processarResultado(Resultado.Carregando)
}