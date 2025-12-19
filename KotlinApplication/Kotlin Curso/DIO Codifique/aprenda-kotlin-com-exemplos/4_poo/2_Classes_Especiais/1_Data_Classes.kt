
/**
    O que é uma Data Class?
    É uma classe especial que serve basicamente como um "contêiner de dados". Pense nela como uma caixa organizada para guardar informações relacionadas.

    Para que serve?
    Principalmente para armazenar dados de forma simples, sem precisar escrever código repetitivo.


    SEM Data Class (trabalhoso):
    class Usuario(val name: String, val id: Int)
    // Teríamos que escrever manualmente:
        // - equals() para comparar
        // - hashCode() para coleções
        // - toString() para imprimir
        // - copy() para copiar
        // Muito código repetitivo!


    COM Data Class (fácil):
    data class Usuario(val name: String, val id: Int)
    // Pronto! Com apenas esta linha, você tem tudo:
        // - equals() e hashCode() automáticos
        // - toString() formatado
        // - copy() para criar cópias
        // - componentN() functions para desestruturação


*/

data class Usuario(val name: String, val id: Int) {       
    (val name: String, val id: Int)
    override fun equals(other: Any?) =
        other is Usuario && other.id == this.id           
}
fun main() {
    val usuario = Usuario("Alex", 1)
    println(usuario)                                      

    val segundoUsuario = Usuario("Alex", 1)
    val terceiroUsuario = Usuario("Max", 2)
    println("usuario == segundoUsuario: ${usuario == segundoUsuario}")  
    println("usuario == terceiroUsuario: ${usuario == terceiroUsuario}")

    // hashCode() function
    println(usuario.hashCode())                             
    println(segundoUsuario.hashCode())
    println(terceiroUsuario.hashCode())

    // copy() function
    println(usuario.copy())                                
    println(usuario.copy(name = "Max"))
    println(usuario === usuario.copy())                        
    println(usuario.copy("Max"))                           
    println(usuario.copy(id = 3))                          

    println("name = ${usuario.component1()}")                 
    println("id = ${usuario.component2()}")
}

/**

    Regras importantes:
        Precisa ter pelo menos 1 parâmetro no construtor
        Parâmetros devem ser val ou var (não pode ter parâmetros sem)
        Não pode ser abstract, open, sealed ou inner


    Quando usar?
        Quando você precisa principalmente armazenar dados
        Para objetos de valor (como DTOs, resultados de API, etc.)
        Quando quer comparação por valor (não por referência)
        Para facilitar cópias com modificações   


    Data Class = Classe preguiçosa que já vem com funcionalidades úteis para dados, sem precisar escrever código repetitivo!

        É como ter uma classe normal, mas com "superpoderes" para trabalhar com dados     
*/