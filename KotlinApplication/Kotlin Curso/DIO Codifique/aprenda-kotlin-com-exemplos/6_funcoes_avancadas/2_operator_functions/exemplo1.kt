/**
 * Operator Functions.
 *
 * @see [Functions]
 * Conceito da operador function permite que você defina o comportamento de operadores
 * para tipos personalizados. Isso é feito definindo funções com a palavra-chave `operator`.


  * O que são?
    São funções especiais que permitem usar operadores (como +, -, *, ==) com seus próprios objetos.

    Analogia Simples
    Imagine que você tem uma classe Caixa:
    Sem operator functions: caixa1.somar(caixa2)
    Com operator functions: caixa1 + caixa2 (muito mais natural!)

    
Operador	Função	Exemplo de Uso
+	plus	a + b
-	minus	a - b
*	times	a * b
/	div	a / b
%	rem	a % b
++	inc	a++ ou ++a
--	dec	a-- ou --a
+a	unaryPlus	+a
-a	unaryMinus	-a
!a	not	!a
==	equals	a == b
!=	equals	a != b
<, >, <=, >=	compareTo	a < b
[]	get	a[i]
[]=	set	a[i] = valor
in	contains	a in b
..	rangeTo	a..b
()	invoke	a()
+=	plusAssign	a += b
-=	minusAssign	a -= b
*=	timesAssign	a *= b
/=	divAssign	a /= b
%=	remAssign	a %= b



 */

fun main() {

// Uso:
val caixa1 = Caixa(5)
val caixa2 = Caixa(3)
val resultado = caixa1 + caixa2  // Chama caixa1.plus(caixa2)
val subtracao = caixa1 - caixa2  // Chama caixa1.minus(caixa2)
val multiplicacao = caixa1 * caixa2  // Chama caixa1.times(caixa2)
val divisao = caixa1 / caixa2  // Chama caixa1.div(caixa  2)
val resto = caixa1 % caixa2  // Chama caixa1.rem(caixa2)
val negativo = -caixa1  // Chama caixa1.unaryMinus()  
val positivo = +caixa1  // Chama caixa1.unaryPlus()
val comparacao = caixa1 > caixa2  // Chama caixa1.compareTo(caixa2)
val quantidade = caixa1[0]  // Chama caixa1.get(0)  


//val quantidadeset = caixa1[0]= 10  // Chama caixa1.set(0, 10)
/**
    data class Caixa(val quantidade: Int)  // ← 'val' torna imutável

    operator fun set(index: Int, value: Int) {
        if (index == 0) {
            // Não pode modificar 'quantidade' porque é 'val'
            this.quantidade = value  // ← ERRO DE COMPILAÇÃO
        }
    }
*/



val igualdade = caixa1 == caixa2  // Chama caixa1.equals(caixa2)

println(resultado) // Caixa(quantidade=8)   
println(subtracao) // Caixa(quantidade=2)
println(multiplicacao) // Caixa(quantidade=15)
println(divisao) // Caixa(quantidade=1)
println(resto) // Caixa(quantidade=2)
println(negativo) // Caixa(quantidade=-5)
println(positivo) // Caixa(quantidade=5)
println(comparacao) // true
println(quantidade) // 5
//println(quantidadeset) // Exception: Cannot set value on immutable data class
println(igualdade) // false
                                      
}

data class Caixa(val quantidade: Int) {
    // Definindo a operator function para o operador +
    operator fun plus(other: Caixa): Caixa {
        return Caixa(this.quantidade + other.quantidade)
    }

    operator fun minus(other: Caixa): Caixa {
        return Caixa(this.quantidade - other.quantidade)
    }

    operator fun times(other: Caixa): Caixa {
        return Caixa(this.quantidade * other.quantidade)
    }

    operator fun div(other: Caixa): Caixa {
        return Caixa(this.quantidade / other.quantidade)
    }

    operator fun rem(other: Caixa): Caixa {
        return Caixa(this.quantidade % other.quantidade)
    }

    operator fun unaryMinus(): Caixa {
        return Caixa(-this.quantidade)
    }

    operator fun unaryPlus(): Caixa {
        return Caixa(+this.quantidade)
    }

    operator fun compareTo(other: Caixa): Int {
        return this.quantidade.compareTo(other.quantidade)
    }

    operator fun get(index: Int): Int {
        return if (index == 0) this.quantidade else throw IndexOutOfBoundsException("Index: $index")
    }

    operator fun set(index: Int, value: Int) {
        if (index == 0) {
            // Note: This is just for demonstration; data classes are immutable by default.
            throw UnsupportedOperationException("Cannot set value on immutable data class")
        } else {
            throw IndexOutOfBoundsException("Index: $index")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Caixa) return false
        return this.quantidade == other.quantidade
    }


}