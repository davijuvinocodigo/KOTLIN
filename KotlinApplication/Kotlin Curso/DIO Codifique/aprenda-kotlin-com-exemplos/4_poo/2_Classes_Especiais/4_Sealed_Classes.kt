
/**
    * Sealed Classes em Kotlin
    *
    * As sealed classes (classes seladas) são um tipo especial de classe que restringe a hierarquia de subclasses.
    * Elas permitem que você defina um conjunto fixo de subclasses dentro do mesmo arquivo, 
    * o que facilita o controle sobre os tipos que podem ser usados em determinadas situações.
    *
    * Isso é especialmente útil em combinação com expressões `when`, onde o compilador pode garantir que todos os casos sejam tratados.
    *
    * Exemplo:
        * - É uma classe "fechada para expansão" - pense nela como uma caixa com compartimentos conhecidos. Você sabe exatamente quais são as possibilidades.
        * Analogia:
            Imagine um menu de restaurante fixo:
            Só tem essas opções (não pode inventar pratos novos)
            Você sabe todas as possibilidades de antemão
            Perfeito para quando há um número limitado de tipos

*/

// SEM Sealed Class (problemático):
class Resultado
class Sucesso(val data: String) : Resultado()
class Erro(val mensagem: String) : Resultado()
// O problema: Qualquer um pode criar novas subclasses!
class ResultadoEstranho : Resultado() // 😕 Isso é permitido!



//COM Sealed Class (controlado):
sealed class Resultado
class Sucesso(val data: String) : Resultado()
class Erro(val mensagem: String) : Resultado()
// FIM! Ninguém mais pode criar subclasses fora deste arquivo



// Como usar com when (a grande vantagem):
fun processarResultado(resultado: Resultado) {
    when (resultado) {
        is Sucesso -> println("Dados: ${resultado.data}")
        is Erro -> println("Erro: ${resultado.mensagem}")
        // Não precisa de 'else'! O compilador sabe todas as possibilidades
    }
}


// Exemplo completo:
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




//Outro Exemplo Comum (Expressões):
sealed class ExpressaoMatematica {
    data class Numero(val valor: Int) : ExpressaoMatematica()
    data class Soma(val a: ExpressaoMatematica, val b: ExpressaoMatematica) : ExpressaoMatematica()
    data class Multiplicacao(val a: ExpressaoMatematica, val b: ExpressaoMatematica) : ExpressaoMatematica()
}

fun calcular(exp: ExpressaoMatematica): Int = when (exp) {
    is ExpressaoMatematica.Numero -> exp.valor
    is ExpressaoMatematica.Soma -> calcular(exp.a) + calcular(exp.b)
    is ExpressaoMatematica.Multiplicacao -> calcular(exp.a) * calcular(exp.b)
}



/**
    Regras importantes:
        Todas as subclasses devem estar no mesmo arquivo
        Ninguém pode criar novas subclasses fora do arquivo
        Pode ser abstract, open ou ter construtor


    Quando usar?
        Status/Estados (carregando, sucesso, erro)
        Comandos/Ações (salvar, deletar, atualizar)
        Expressões/Árvores (como no exemplo matemático)
        Eventos (clique, arrastar, toque)
        Resultados de operações (sucesso/falha)    
*/


/*
            Resumo:
            Sealed Class = "É isso ou aquilo, e só!"
            Como um semáforo: só tem vermelho, amarelo e verde - não tem "roxo" ou "rosa"! 🚦

            Perfeito para quando você quer limitar as possibilidades e ter código à prova de erros!
*/


































