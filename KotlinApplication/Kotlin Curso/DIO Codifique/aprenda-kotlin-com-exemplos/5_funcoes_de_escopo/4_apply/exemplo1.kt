/**
 * Funções de Escopo: [apply].
 *
 * @see [apply]
 * Similar ao also, mas usa this como referência. Ideal para inicialização de objetos.
        *   Função: Retorna o próprio objeto (this)
            Referência: this
            Uso: Inicializar/configurar objetos
 */

fun exemploApply() {
    // Inicialização de objetos
    val pessoa = Pessoa().apply {
        nome = "Carlos"
        idade = 25
        endereco = "Av. B, 456"
    }
    
    println("Pessoa: ${pessoa.nome}, ${pessoa.idade} anos")
    
    // Configuração de views (Android)
    val textView = TextView().apply {
        text = "Olá, Mundo!"
        textSize = 16.0f
        setTextColor(Color.BLACK)
        gravity = Gravity.CENTER
    }
    
    // Trabalhando com collections
    val listaNumeros = mutableListOf<Int>().apply {
        for (i in 1..10) {
            add(i * i)
        }
        shuffle()
    }
    
    println("Números ao quadrado: $listaNumeros")
}