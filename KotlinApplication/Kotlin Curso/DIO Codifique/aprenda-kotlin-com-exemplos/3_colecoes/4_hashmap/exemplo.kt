/**
    * HashMap e LinkedHashMap.
    * HashMap é uma implementação de Map que armazena os pares chave-valor em uma tabela hash, permitindo acesso rápido aos valores com base nas chaves.
    * LinkedHashMap é uma subclasse de HashMap que mantém a ordem de inserção dos elementos.
    * @see [HashMap]


    * Diferentemente do Map padrão, HashMap e LinkedHashMap são mutáveis por padrão.
    * Diferencia entre HashMap e LinkedHashMap: HashMap não garante a ordem dos elementos, enquanto LinkedHashMap mantém a ordem de inserção.

    * Deferencia do Map padrão: Map pode ser imutável ou mutável, enquanto HashMap e LinkedHashMap são sempre mutáveis. 



    * Quando usar Map, HashMap ou LinkedHashMap:
    * Use [Map] quando precisar de uma coleção de pares chave-valor e não se importar com a mutabilidade ou ordem.
    * Use [HashMap] quando precisar de acesso rápido aos valores e não se importar com a ordem dos elementos.
    * Use [LinkedHashMap] quando precisar manter a ordem de inserção dos elementos além do acesso rápido aos valores.

*/


fun main() {
    hashMapExemplo()
    linkedHashMapExemplo()
}

fun hashMapExemplo() {
    val hashMap: HashMap<String, Int> = hashMapOf(
        "Alice" to 30,
        "Bob" to 25,
        "Charlie" to 35
    )

    hashMap["Diana"] = 28 // Adiciona um novo par chave-valor
    hashMap.remove("Bob") // Remove o par com a chave "Bob"

    println("HashMap: $hashMap")
}

fun linkedHashMapExemplo() {
    val linkedHashMap: LinkedHashMap<String, Int> = linkedMapOf(
        "Alice" to 30,
        "Bob" to 25,
        "Charlie" to 35
    )

    linkedHashMap["Diana"] = 28 // Adiciona um novo par chave-valor
    linkedHashMap.remove("Bob") // Remove o par com a chave "Bob"

    println("LinkedHashMap: $linkedHashMap")
}

