// Classe que queremos construir
class Pizza private constructor(
    val tamanho: String,
    val queijo: Boolean,
    val pepperoni: Boolean,
    val cogumelos: Boolean,
    val bacon: Boolean,
    val cebola: Boolean
) {
    // Builder como classe interna
    class Builder(private val tamanho: String) {
        private var queijo: Boolean = false
        private var pepperoni: Boolean = false
        private var cogumelos: Boolean = false
        private var bacon: Boolean = false
        private var cebola: Boolean = false
        
        fun adicionarQueijo(): Builder {
            this.queijo = true
            return this
        }
        
        fun adicionarPepperoni(): Builder {
            this.pepperoni = true
            return this
        }
        
        fun adicionarCogumelos(): Builder {
            this.cogumelos = true
            return this
        }
        
        fun adicionarBacon(): Builder {
            this.bacon = true
            return this
        }
        
        fun adicionarCebola(): Builder {
            this.cebola = true
            return this
        }
        
        fun build(): Pizza {
            return Pizza(tamanho, queijo, pepperoni, cogumelos, bacon, cebola)
        }
    }
    
    override fun toString(): String {
        return "Pizza(tamanho='$tamanho', queijo=$queijo, pepperoni=$pepperoni, " +
               "cogumelos=$cogumelos, bacon=$bacon, cebola=$cebola)"
    }
}



fun main() {
    // Construindo uma pizza passo a passo
    val pizza1 = Pizza.Builder("Média")
        .adicionarQueijo()
        .adicionarPepperoni()
        .adicionarCogumelos()
        .build()
    
    println(pizza1) // Pizza(tamanho='Média', queijo=true, pepperoni=true, cogumelos=true, bacon=false, cebola=false)
    
    val pizza2 = Pizza.Builder("Grande")
        .adicionarQueijo()
        .adicionarBacon()
        .adicionarCebola()
        .build()
    
    println(pizza2) // Pizza(tamanho='Grande', queijo=true, pepperoni=false, cogumelos=false, bacon=true, cebola=true)
    
    // Pizza simples, só queijo
    val pizza3 = Pizza.Builder("Pequena")
        .adicionarQueijo()
        .build()
    
    println(pizza3) // Pizza(tamanho='Pequena', queijo=true, pepperoni=false, cogumelos=false, bacon=false, cebola=false)
}


/**

    Padrão Builder em Kotlin
    O que é o Builder?
    O Builder é um padrão de projeto criacional que permite construir objetos complexos passo a passo. É útil quando um objeto tem muitos parâmetros opcionais ou quando a construção precisa ser clara e legível.

    Problema que Resolve
    Imagine uma classe com muitos parâmetros no construtor, alguns obrigatórios, outros opcionais:

*/


/**

    Quando Usar
    Quando o objeto tem muitos parâmetros
    Quando alguns parâmetros são opcionais
    Quando quer diferentes representações do mesmo objeto
    Quando o objeto precisa ser imutável após criação
*/