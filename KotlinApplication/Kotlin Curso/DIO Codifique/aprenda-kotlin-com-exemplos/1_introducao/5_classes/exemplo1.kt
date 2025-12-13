/**
 * Classes Tradicionais.
 *
 * @see [Classes](https://play.kotlinlang.org/byExample/01_introduction/05_Classes)
 */

class Customer                                  // 1 

// 2 com constructor personalizado que recebe parâmetros encapsulados com metodos get e set
class Contact(val id: Int, var email: String)   

fun main() {

    val customer = Customer()                   // 3
    
    val contact = Contact(1, "mary@gmail.com")  // 4

    println(contact.id)                         // 5
    println(contact.email)
    contact.email = "jane@gmail.com"            // 6
    println(contact.email)
}