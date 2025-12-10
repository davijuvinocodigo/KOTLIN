object SingletonBasico {
    private var contador: Int = 0
    
    fun incrementar() {
        contador++
        println("Contador: $contador")
    }
    
    fun getContador(): Int = contador
}

// Uso:
fun main() {
    SingletonBasico.incrementar()  // Contador: 1
    SingletonBasico.incrementar()  // Contador: 2
    
    // Todas as chamadas acessam a MESMA instância
    println(SingletonBasico.getContador())  // 2
	
}

/**
    Padrão Singleton em Kotlin

    O que é o Singleton?
    O Singleton é um padrão de projeto criacional que garante que uma classe tenha apenas uma única instância durante toda a execução do aplicativo, e fornece um ponto global de acesso a essa instância.

    Quando usar?
    Quando você precisa de exatamente uma instância de uma classe
    Para controlar acesso a recursos compartilhados (banco de dados, arquivos)
    Para caches, configurações globais, loggers
    Para objetos que consomem muitos recursos (evitar múltiplas instâncias)

 */
