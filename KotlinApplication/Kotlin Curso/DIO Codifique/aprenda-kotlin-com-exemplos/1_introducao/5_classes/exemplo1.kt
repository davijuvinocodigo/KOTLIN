/**
 * Classes Tradicionais.
 *
 * @see [Classes](https://play.kotlinlang.org/byExample/01_introduction/05_Classes)
 */

// 1 classe simples sem construtor personalizado
class Customer                           

// 2 com constructor personalizado que recebe parâmetros encapsulados com metodos get e set
class Contact(val id: Int, var email: String)   

fun main() {

    val customer = Customer()                   // 3 cria uma instância da classe Customer
    
    val contact = Contact(1, "mary@gmail.com")  // 4 cria uma instância da classe Contact

    println(contact.id)                         // 5 referecia ao atributo id
    println(contact.email)
    contact.email = "jane@gmail.com"            // 6 modifica o atributo email
    println(contact.email)
}