class Company<T>(name: T) {
    var companyName = name
}

fun main() {
    val c1 = Company("GeeksforGeeks")
    val c2 = Company(1234)
    
    println(c1.companyName)
    println(c2.companyName)
}