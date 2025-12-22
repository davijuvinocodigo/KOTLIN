// Data class já gera automaticamente component1(), component2(), component3()
// para as propriedades declaradas no construtor primário
// Então NÃO podemos definir nossas próprias versões

// Mudamos para class normal para ter controle total
class CarteiraDigital(
    var nome: String,
    var saldo: Double = 0.0,
    val moeda: String = "R$"
) {
    
    // ==================== OPERADORES ARITMÉTICOS ====================
    
    // 1. PLUS (+) - Adicionar saldo de outra carteira
    operator fun plus(outra: CarteiraDigital): CarteiraDigital {
        return CarteiraDigital(
            nome = "${this.nome} + ${outra.nome}",
            saldo = this.saldo + outra.saldo,
            moeda = this.moeda
        )
    }
    
    // Sobrecarga: adicionar valor direto
    // REMOVER ESSA FUNÇÃO para resolver ambiguidade com plusAssign
    // Vamos renomear para uma função auxiliar
    fun adicionar(valor: Double): CarteiraDigital {
        return CarteiraDigital(
            nome = this.nome,
            saldo = this.saldo + valor,
            moeda = this.moeda
        )
    }
    
    // 2. MINUS (-) - Subtrair saldo
    // REMOVER ESSA FUNÇÃO para resolver ambiguidade com minusAssign
    fun subtrair(valor: Double): CarteiraDigital {
        return CarteiraDigital(
            nome = this.nome,
            saldo = this.saldo - valor,
            moeda = this.moeda
        )
    }
    
    // 3. TIMES (*) - Multiplicar saldo (investimento)
    // REMOVER ESSA FUNÇÃO para resolver ambiguidade com timesAssign
    fun multiplicar(taxa: Double): CarteiraDigital {
        return CarteiraDigital(
            nome = "$nome (Investido)",
            saldo = this.saldo * taxa,
            moeda = this.moeda
        )
    }
    
    // ==================== OPERADORES UNÁRIOS ====================
    
    // 4. UNARY MINUS (-) - Negativo (dívida)
    operator fun unaryMinus(): CarteiraDigital {
        return CarteiraDigital(
            nome = "Dívida de $nome",
            saldo = -this.saldo,
            moeda = this.moeda
        )
    }
    
    // 5. UNARY PLUS (+) - Positivo (só para demonstração)
    operator fun unaryPlus(): CarteiraDigital {
        return CarteiraDigital(
            nome = "Positiva: $nome",
            saldo = kotlin.math.abs(this.saldo),
            moeda = this.moeda
        )
    }
    
    // 6. NOT (!) - Verificar se está sem saldo
    operator fun not(): Boolean {
        return saldo <= 0
    }
    
    // ==================== OPERADORES DE ATRIBUIÇÃO ====================
    
    // 7. PLUS ASSIGN (+=) - Depositar dinheiro
    operator fun plusAssign(valor: Double) {
        this.saldo += valor
        println("✅ Depositado $moeda$valor na carteira $nome")
    }
    
    // 8. MINUS ASSIGN (-=) - Sacar dinheiro
    operator fun minusAssign(valor: Double) {
        if (saldo >= valor) {
            this.saldo -= valor
            println("✅ Sacado $moeda$valor da carteira $nome")
        } else {
            println("❌ Saldo insuficiente!")
        }
    }
    
    // 9. TIMES ASSIGN (*=) - Aplicar juros/rendimento
    operator fun timesAssign(taxa: Double) {
        val rendimento = this.saldo * (taxa - 1.0)
        this.saldo *= taxa
        println("📈 Rendimento: $moeda${"%.2f".format(rendimento)}")
    }
    
    // ==================== OPERADORES DE COMPARAÇÃO ====================
    
    // 10. COMPARE TO - Comparar saldos
    operator fun compareTo(outra: CarteiraDigital): Int {
        return this.saldo.compareTo(outra.saldo)
    }
    
    // ==================== OPERADOR DE ÍNDICE ====================
    
    // 11. GET ([]) - Acesso por índice (0 = nome, 1 = saldo, 2 = moeda)
    operator fun get(index: Int): Any {
        return when (index) {
            0 -> nome
            1 -> saldo
            2 -> moeda
            else -> throw IndexOutOfBoundsException("Índice $index inválido")
        }
    }
    
    // 12. SET ([]=) - Modificar por índice
    operator fun set(index: Int, value: Any) {
        when (index) {
            0 -> nome = value as String
            1 -> saldo = value as Double
            2 -> {} // moeda é val, não pode ser alterada
            else -> throw IndexOutOfBoundsException("Índice $index inválido")
        }
    }
    
    // ==================== OPERADOR INVOKE ====================
    
    // 13. INVOKE () - "Usar" a carteira como função
    operator fun invoke(acao: String, valor: Double = 0.0): String {
        return when (acao.lowercase()) {
            "saldo" -> "Seu saldo é: $moeda${"%.2f".format(saldo)}"
            "depositar" -> {
                this.saldo += valor
                "Depósito de $moeda$valor realizado!"
            }
            "sacar" -> {
                if (saldo >= valor) {
                    this.saldo -= valor
                    "Saque de $moeda$valor realizado!"
                } else {
                    "Saldo insuficiente para saque!"
                }
            }
            else -> "Ação '$acao' não reconhecida"
        }
    }
    
    // ==================== OPERADOR IN ====================
    
    // 14. CONTAINS (in) - Verificar se valor está no intervalo permitido
    operator fun contains(valor: Double): Boolean {
        return valor in 0.0..saldo
    }
    
    // ==================== OPERADORES DE INCREMENTO/DECREMENTO ====================
    
    // 15. INC (++) - "Próximo nível" da carteira
    operator fun inc(): CarteiraDigital {
        val nova = CarteiraDigital(
            nome = "$nome PRO",
            saldo = saldo * 1.1, // 10% de bônus
            moeda = moeda
        )
        println("🎉 $nome evoluiu para ${nova.nome}!")
        return nova
    }
    
    // 16. DEC (--) - "Reiniciar" carteira
    operator fun dec(): CarteiraDigital {
        val nova = CarteiraDigital(
            nome = "$nome (Reiniciada)",
            saldo = 0.0,
            moeda = moeda
        )
        println("🔄 $nome foi reiniciada")
        return nova
    }
    
    // ==================== DESESTRUTURAÇÃO PERSONALIZADA ====================
    
    // Data classes geram automaticamente, mas como usamos class normal,
    // podemos definir nossas próprias funções componentN
    
    operator fun component1(): String = nome
    operator fun component2(): Double = saldo
    operator fun component3(): String = moeda
    
    override fun toString(): String {
        return "$nome: $moeda${"%.2f".format(saldo)}"
    }
    
    // Função para cópia (similar ao copy() de data class)
    fun copy(nome: String = this.nome, saldo: Double = this.saldo, moeda: String = this.moeda): CarteiraDigital {
        return CarteiraDigital(nome, saldo, moeda)
    }
}

// ==================== FUNÇÃO PRINCIPAL ====================

fun main() {
    println("💰 === EXEMPLO DE CARTEIRA DIGITAL === 💰\n")
    
    // Criando carteiras
    val carteiraJoao = CarteiraDigital("João", 1000.0)
    val carteiraMaria = CarteiraDigital("Maria", 500.0)
    
    println("1. 👥 Carteiras criadas:")
    println("   - $carteiraJoao")
    println("   - $carteiraMaria")
    println()
    
    // 1. Operador PLUS (+) - Só funciona com outra CarteiraDigital
    println("2. ➕ SOMA de carteiras (só funciona entre carteiras):")
    val carteiraCasada = carteiraJoao + carteiraMaria
    println("   $carteiraJoao + $carteiraMaria = $carteiraCasada")
    
    // Usando a função auxiliar para adicionar valor
    println("   João.adicionar(200.0) = ${carteiraJoao.adicionar(200.0)}")
    println()
    
    // 2. Usando função auxiliar para subtrair
    println("3. ➖ SUBTRAÇÃO (usando função auxiliar):")
    val carteiraPobre = carteiraJoao.subtrair(800.0)
    println("   $carteiraJoao.subtrair(800.0) = $carteiraPobre")
    println()
    
    // 3. Usando função auxiliar para multiplicar
    println("4. ✖️ MULTIPLICAÇÃO (usando função auxiliar):")
    val carteiraInvestida = carteiraMaria.multiplicar(1.5)
    println("   $carteiraMaria.multiplicar(1.5) = $carteiraInvestida")
    println()
    
    // 4. Operador UNARY MINUS (-)
    println("5. 🔄 NEGATIVO (dívida):")
    val divida = -carteiraJoao
    println("   -$carteiraJoao = $divida")
    println()
    
    // 5. Operador UNARY PLUS (+)
    println("6. 🔄 POSITIVO (absoluto):")
    val carteiraNegativa = CarteiraDigital("Negativa", -50.0)
    val positiva = +carteiraNegativa
    println("   +$carteiraNegativa = $positiva")
    println()
    
    // 6. Operador NOT (!)
    println("7. ❗ NOT (verificar saldo negativo):")
    println("   !$carteiraNegativa = ${!carteiraNegativa}")
    println("   !$carteiraJoao = ${!carteiraJoao}")
    println()
    
    // 7. Operador PLUS ASSIGN (+=)
    println("8. 📥 DEPÓSITO (+=):")
    var minhaCarteira = CarteiraDigital("Minha Carteira", 100.0)
    println("   Antes: $minhaCarteira")
    minhaCarteira += 50.0
    println("   Depois: $minhaCarteira")
    println()
    
    // 8. Operador MINUS ASSIGN (-=)
    println("9. 📤 SAQUE (-=):")
    println("   Antes: $minhaCarteira")
    minhaCarteira -= 30.0
    println("   Depois: $minhaCarteira")
    println()
    
    // 9. Operador TIMES ASSIGN (*=)
    println("10. 📈 JUROS (*=):")
    println("   Antes: $minhaCarteira")
    minhaCarteira *= 1.1  // 10% de juros
    println("   Depois: $minhaCarteira")
    println()
    
    // 10. Operador COMPARE TO
    println("11. ⚖️ COMPARAÇÃO:")
    println("   $carteiraJoao > $carteiraMaria ? ${carteiraJoao > carteiraMaria}")
    println("   $carteiraJoao < $carteiraMaria ? ${carteiraJoao < carteiraMaria}")
    println()
    
    // 11. Operador GET []
    println("12. 🔍 ACESSO POR ÍNDICE []:")
    println("   minhaCarteira[0] = ${minhaCarteira[0]}")
    println("   minhaCarteira[1] = ${minhaCarteira[1]}")
    println("   minhaCarteira[2] = ${minhaCarteira[2]}")
    println()
    
    // 12. Operador SET []=
    println("13. ✏️ MODIFICAÇÃO POR ÍNDICE []=")
    println("   Antes: $minhaCarteira")
    minhaCarteira[0] = "Carteira VIP"
    minhaCarteira[1] = 1000.0
    println("   Depois: $minhaCarteira")
    println()
    
    // 13. Operador INVOKE ()
    println("14. 📞 INVOKE (usar como função):")
    println("   minhaCarteira(\"saldo\") = ${minhaCarteira("saldo")}")
    println("   minhaCarteira(\"depositar\", 100.0) = ${minhaCarteira("depositar", 100.0)}")
    println("   Resultado: $minhaCarteira")
    println()
    
    // 14. Operador IN
    println("15. 🔎 CONTAINS (in):")
    println("   50.0 in minhaCarteira = ${50.0 in minhaCarteira}")
    println("   2000.0 in minhaCarteira = ${2000.0 in minhaCarteira}")
    println()
    
    // 15. Operador INC (++)
    println("16. ⬆️ INCREMENTO (++):")
    var carteiraPremium = CarteiraDigital("Premium", 500.0)
    println("   Antes: $carteiraPremium")
    val carteiraNova = ++carteiraPremium
    println("   Depois (nova): $carteiraNova")
    println("   Original ainda: $carteiraPremium")
    println()
    
    // 16. Operador DEC (--)
    println("17. ⬇️ DECREMENTO (--):")
    println("   Antes: $carteiraPremium")
    val carteiraResetada = --carteiraPremium
    println("   Depois (resetada): $carteiraResetada")
    println("   Original ainda: $carteiraPremium")
    println()
    
    // 17. Desestruturação
    println("18. 🧩 DESESTRUTURAÇÃO (agora funciona):")
    val (nome, saldo, moeda) = minhaCarteira
    println("   val (nome, saldo, moeda) = minhaCarteira")
    println("   nome = $nome, saldo = $saldo, moeda = $moeda")
    println()
    
    // Testando copy()
    println("19. 📋 CÓPIA (método copy personalizado):")
    val copia = minhaCarteira.copy(nome = "Cópia da Carteira")
    println("   minhaCarteira.copy(nome = \"Cópia da Carteira\") = $copia")
    println()
    
    // Resumo
    println("🎯 RESUMO DOS OPERADORES IMPLEMENTADOS:")
    println("""
    Aritméticos: + (só entre carteiras)
    Unários: +a, -a, !a
    Atribuição: +=, -=, *=
    Comparação: >, <, >=, <=
    Acesso: [], []=
    Especiais: (), in, ++, --
    Desestruturação: component1, component2, component3
    Auxiliares: adicionar(), subtrair(), multiplicar(), copy()
    """.trimIndent())
}