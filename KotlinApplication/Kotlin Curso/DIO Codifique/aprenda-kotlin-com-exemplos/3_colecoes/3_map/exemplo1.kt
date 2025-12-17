/**
 * Mapas.
 * Um Map em Kotlin é uma coleção de pares chave-valor. Ele mapeia chaves para valores e não permite chaves duplicadas. 
   As chaves são usadas para recuperar valores posteriormente.
 * @see [Map]
 */

fun main() {
    mapImutaveis()
    mapMutaveis()
}


fun mapImutaveis() {
    // Mapas imutáveis
    val paises: Map<String, String> = mapOf(
        "BR" to "Brasil",
        "US" to "Estados Unidos",
        "FR" to "França"
    )

    println(paises)                   // Imprime o mapa completo
    println(paises["US"])             // Acessa o valor associado à chave "US"
    println(paises.size)              // Tamanho do mapa
    println(paises.containsKey("FR")) // Verifica se a chave "FR" está no mapa
    println(paises.containsValue("Brasil")) // Verifica se o valor "Brasil" está no mapa
}


fun mapMutaveis() {
    // Mapas mutáveis
    val capitais: MutableMap<String, String> = mutableMapOf(
        "BR" to "Brasília",
        "US" to "Washington, D.C.",
        "FR" to "Paris"
    )

    capitais["DE"] = "Berlim"         // Adiciona um par chave-valor
    capitais.remove("US")             // Remove o par com a chave "US"

    println(capitais)                 // Imprime o mapa atualizado
}


