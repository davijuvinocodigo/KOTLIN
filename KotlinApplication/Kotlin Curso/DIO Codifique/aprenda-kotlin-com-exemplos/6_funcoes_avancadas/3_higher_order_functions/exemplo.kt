/**
    Funções de Ordem Superior (Higher-Order Functions) em Kotlin
    📚 Conceito Básico
    Funções de Ordem Superior são funções que podem:

    Receber outras funções como parâmetros
    Retornar funções como resultado

    Ou seja, tratam funções como "cidadãos de primeira classe" (first-class citizens).

    🎯 Analogia Simples
    Analogia do Restaurante
    Pense em um chef de cozinha:

    Situação	Explicação
    Chef normal	Recebe ingredientes, prepara um prato específico
    Chef de alta ordem	Recebe outro chef e instruções, delega o trabalho
    Exemplo:

    Você pede ao chef principal: "Use o chef de sobremesas para fazer um bolo de chocolate"
    O chef principal não faz o bolo, ele delega para o especialista

*/


// # 1. Função que Recebe Outra Função
// Função normal
fun dobrar(numero: Int): Int {
    return numero * 2
}

// Função de ORDEM SUPERIOR
fun processarNumero(numero: Int, operacao: (Int) -> Int): Int {
    return operacao(numero)  // Chama a função recebida como parâmetro
}

// Uso
fun main() {
    val resultado = processarNumero(5, ::dobrar)
    println(resultado)  // 10
    
    // Ou com lambda (função anônima)
    val resultado2 = processarNumero(5, { it * 3 })
    println(resultado2)  // 15
}








// # 2. Função que Retorna Outra Função
fun criarMultiplicador(multiplicador: Int): (Int) -> Int {
    return { numero -> numero * multiplicador }
}

// Uso
fun main() {
    val dobrar = criarMultiplicador(2)
    val triplicar = criarMultiplicador(3)
    
    println(dobrar(5))    // 10
    println(triplicar(5)) // 15
}

/**
    💡 Dica Prática
    Pense assim: a função externa é uma fábrica que produz funções especializadas.
*/
// FÁBRICA de funções matemáticas
fun fabricaDeOperacoes(operador: Char): (Int, Int) -> Int {
    return when (operador) {
        '+' -> { a, b -> a + b }
        '-' -> { a, b -> a - b }
        '*' -> { a, b -> a * b }
        else -> { a, b -> a / b }
    }
}

fun main() {
    // PRODUZ funções
    val somar = fabricaDeOperacoes('+')
    val dividir = fabricaDeOperacoes('/')
    
    // USA as funções produzidas
    println(somar(10, 5))   // 15
    println(dividir(20, 4)) // 5
}










// Funções de Coleção (usam HOFs internamente)
val numeros = listOf(1, 2, 3, 4, 5)

// map: transforma cada elemento (recebe uma função)
val dobrados = numeros.map { it * 2 }
// Resultado: [2, 4, 6, 8, 10]

// filter: filtra elementos (recebe uma função que retorna true/false)
val pares = numeros.filter { it % 2 == 0 }
// Resultado: [2, 4]

// forEach: executa ação para cada elemento
numeros.forEach { println("Número: $it") }









// Exemplo de Vida Real: Sistema de Notificações

// Tipo de função para enviar notificação
typealias EnviadorNotificacao = (String, String) -> Unit

// Função de alta ordem
fun processarUsuario(
    nome: String,
    enviador: EnviadorNotificacao
) {
    // Lógica de processamento...
    val mensagem = "Olá, $nome! Seu cadastro foi processado."
    
    // Usa a função recebida como parâmetro
    enviador(nome, mensagem)
}

// Funções diferentes de envio
fun enviarEmail(destinatario: String, mensagem: String) {
    println("📧 Email para $destinatario: $mensagem")
}

fun enviarSMS(destinatario: String, mensagem: String) {
    println("📱 SMS para $destinatario: $mensagem")
}

// Uso
fun main() {
    // Escolhe qual função usar
    processarUsuario("João", ::enviarEmail)
    processarUsuario("Maria", ::enviarSMS)
    
    // Ou com lambda
    processarUsuario("Carlos") { nome, msg ->
        println("📲 Push para $nome: $msg")
    }
}



/**
    🎨 Analogia da Fábrica de Brinquedos
    Imagine uma fábrica de montar brinquedos:
*/

// Máquina principal (função de alta ordem)
fun fabricaDeBrinquedos(
    pecas: List<String>,
    montador: (List<String>) -> String
): String {
    return montador(pecas)  // Delega a montagem
}

// Diferentes "especialistas" de montagem
val montadorCarro = { pecas: List<String> -> 
    "Carro montado com: ${pecas.joinToString()}"
}

val montadorAviao = { pecas: List<String> -> 
    "Avião montado com: ${pecas.joinToString()}"
}

// Uso
val pecas = listOf("rodas", "motor", "volante")
val brinquedo = fabricaDeBrinquedos(pecas, montadorCarro)





/**
    💡 Benefícios

        Reutilização de código: Lógica comum fica em uma função, comportamento específico é passado como parâmetro
        Flexibilidade: Muda comportamento sem alterar estrutura
        Abstração: Esconde detalhes de implementação
        Composição: Combina funções simples para criar comportamentos complexos
*/

/**
    🎓 Resumo em 3 Pontos

        "Funções que lidam com funções" - Recebem ou retornam outras funções
        "Delegação inteligente" - A função principal sabe O QUE fazer, delega o COMO fazer
        "Caixa de ferramentas" - Você passa a ferramenta (função) certa para cada trabalho
 */

 /**
    📊 Comparação Visual

    FUNÇÃO NORMAL:
        Entrada → [Processamento] → Saída
        Ex: 5 → [×2] → 10

    FUNÇÃO DE ALTA ORDEM:
        Entrada + Função → [Orquestração] → Saída
        Ex: 5 + (×3) → [Aplica a função] → 15
 */
  