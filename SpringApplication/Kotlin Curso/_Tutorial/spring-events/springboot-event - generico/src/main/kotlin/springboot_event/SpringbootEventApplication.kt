package springboot_event

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class SpringbootEventApplication

fun main(args: Array<String>) {
	runApplication<SpringbootEventApplication>(*args)
}
