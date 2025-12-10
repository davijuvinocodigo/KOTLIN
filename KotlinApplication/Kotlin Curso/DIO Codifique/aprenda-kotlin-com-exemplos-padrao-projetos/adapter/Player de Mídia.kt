// Interface moderna que queremos usar
interface PlayerModerno {
    fun play(nomeArquivo: String)
}

// Player antigo com interface diferente
class PlayerAntigo {
    fun reproduzirMusica(caminhoCompleto: String) {
        println("Reproduzindo: $caminhoCompleto")
    }
}

// Adapter
class PlayerAdapter(private val playerAntigo: PlayerAntigo) : PlayerModerno {
    
    override fun play(nomeArquivo: String) {
        // O player antigo precisa do caminho completo
        val caminhoCompleto = "/musicas/$nomeArquivo.mp3"
        playerAntigo.reproduzirMusica(caminhoCompleto)
    }
}

// Uso
fun main() {
    val playerVelho = PlayerAntigo()
    val adaptador = PlayerAdapter(playerVelho)
    
    // Agora podemos usar a interface moderna
    adaptador.play("minha-musica")
    // Saída: Reproduzindo: /musicas/minha-musica.mp3
}