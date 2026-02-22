package com.livros


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LivrosApplication

fun main(args: Array<String>) {
    runApplication<LivrosApplication>(*args)
}
