// ========== INTERFACE ESPERADA PELO CLIENTE ==========
// O cliente espera uma tomada brasileira
interface TomadaBrasileira {
    fun conectarPlugBrasileiro(): String
}

// ========== CLASSE QUE JÁ EXISTE (INCOMPATÍVEL) ==========
// Temos um plugue americano que não é compatível
class PlugueAmericano {
    fun conectarNaTomadaAmericana(): String {
        return "Plugue americano conectado"
    }
}

// ========== ADAPTER ==========
class AdaptadorAmericanoParaBrasileiro(
    private val plugueAmericano: PlugueAmericano
) : TomadaBrasileira {
    
    override fun conectarPlugBrasileiro(): String {
        // O adaptador faz a conversão
        return "Adaptador: ${plugueAmericano.conectarNaTomadaAmericana()} -> Agora funciona na tomada brasileira!"
    }
}

// ========== USO ==========
fun main() {
    val plugueAmericano = PlugueAmericano()
    val adaptador = AdaptadorAmericanoParaBrasileiro(plugueAmericano)
    
    println(adaptador.conectarPlugBrasileiro())
    // Saída: Adaptador: Plugue americano conectado -> Agora funciona na tomada brasileira!
}