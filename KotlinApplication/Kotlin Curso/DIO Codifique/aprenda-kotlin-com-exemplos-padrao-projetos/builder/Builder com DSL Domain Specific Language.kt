/**
    Kotlin permite criar Builders mais elegantes usando recursos da linguagem:

*/

// Classe de produto
class Computador(
    val processador: String,
    val memoriaRAM: Int,
    val armazenamento: Int,
    val placaDeVideo: String?,
    val temSSD: Boolean
) {
    override fun toString(): String {
        return "Computador(processador='$processador', RAM=${memoriaRAM}GB, " +
               "armazenamento=${armazenamento}GB, placaDeVideo=$placaDeVideo, temSSD=$temSSD)"
    }
}

// Builder com DSL
class ComputadorBuilder {
    var processador: String = "i5"
    var memoriaRAM: Int = 8
    var armazenamento: Int = 1000
    var placaDeVideo: String? = null
    var temSSD: Boolean = false
    
    fun build(): Computador {
        return Computador(processador, memoriaRAM, armazenamento, placaDeVideo, temSSD)
    }
}

// Função de construção
fun computador(block: ComputadorBuilder.() -> Unit): Computador {
    val builder = ComputadorBuilder()
    builder.block()
    return builder.build()
}

// Uso do Builder com DSL
fun main() {
    val meuPC = computador {
        processador = "i7"
        memoriaRAM = 16
        armazenamento = 512
        temSSD = true
        placaDeVideo = "NVIDIA RTX 3060"
    }
    
    println(meuPC)
    // Computador(processador='i7', RAM=16GB, armazenamento=512GB, placaDeVideo=NVIDIA RTX 3060, temSSD=true)
    
    val pcSimples = computador {
        // Usa valores padrão
    }
    
    println(pcSimples)
    // Computador(processador='i5', RAM=8GB, armazenamento=1000GB, placaDeVideo=null, temSSD=false)
}



/**

    Vantagens do Builder
    
    Código mais legível: Nomeia os parâmetros sendo configurados
    Imutabilidade: O objeto construído pode ser imutável
    Validação: Pode validar parâmetros antes de construir
    Flexibilidade: Diferentes representações do mesmo objeto
    Encadeamento: Métodos retornam o builder para chamadas encadeadas

*/