// Interface que nosso sistema espera (Celsius)
interface TermometroCelsius {
    fun getTemperaturaCelsius(): Double
}

// Sistema legado que trabalha em Fahrenheit
class TermometroFahrenheit {
    fun medirTemperatura(): Double {
        return 98.6  // Temperatura normal em Fahrenheit
    }
}

// Adapter que converte Fahrenheit para Celsius
class AdaptadorFahrenheitParaCelsius(
    private val termometroF: TermometroFahrenheit
) : TermometroCelsius {
    
    override fun getTemperaturaCelsius(): Double {
        val fahrenheit = termometroF.medirTemperatura()
        // Fórmula: C = (F - 32) × 5/9
        return (fahrenheit - 32) * 5 / 9
    }
}

// Uso
fun main() {
    val termometroAntigo = TermometroFahrenheit()
    val adaptador = AdaptadorFahrenheitParaCelsius(termometroAntigo)
    
    println("Temperatura em Fahrenheit: ${termometroAntigo.medirTemperatura()}°F")
    println("Temperatura em Celsius: ${adaptador.getTemperaturaCelsius()}°C")
    // Saída: 
    // Temperatura em Fahrenheit: 98.6°F
    // Temperatura em Celsius: 37.0°C
}