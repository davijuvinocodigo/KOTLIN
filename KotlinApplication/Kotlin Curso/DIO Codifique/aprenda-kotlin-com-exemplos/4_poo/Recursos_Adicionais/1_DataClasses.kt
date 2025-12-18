/*
    * Data Classes em Kotlin
    * 
    * Data classes são usadas para armazenar dados. Elas fornecem automaticamente
    * métodos úteis como equals(), hashCode(), toString(), e copy().
    */
*/

data class Aluno(
    val matricula: String,
    val nome: String,
    val curso: String
) {
    // Pode conter métodos também
    fun exibirInfo() {
        println("$nome - $curso ($matricula)")
    }
}

fun main() {
    val aluno1 = Aluno("2023001", "Maria", "Engenharia")
    val aluno2 = Aluno("2023001", "Maria", "Engenharia")
    val aluno3 = aluno1.copy(nome = "Maria Silva")
    
    println(aluno1)  // toString() automático
    println(aluno1 == aluno2)  // equals() automático: true
    println(aluno1.hashCode()) // hashCode() automático
    println(aluno3)
    
    // Desestruturação
    val (matricula, nome, curso) = aluno1
    println("Matrícula: $matricula")
}