package org.ConversorTemperatura

fun celciusToFahrenheit(celcius: Double): Double {
    return (celcius * 9 / 5) + 32
}

fun fahrenheitToCelcius(fahrenheit: Double): Double {
    return (fahrenheit - 32) * 5 / 9
}

fun main() {
    println("=== Conversor de Temperatura ===")
    println("Escolha o tipo de conversão:")
    println("1. Celsius para Fahrenheit")
    println("2. Fahrenheit para Celsius")
    print("Opção: ")

    val option = readLine()?.toIntOrNull()

    if (option == null || (option != 1 && option != 2)) {
        println("Opção inválida. Encerrando o programa.")
        return
    }

    print("Digite a temperatura: ")
    val temperature = readLine()?.toDoubleOrNull()

    if (temperature == null) {
        println("Temperatura inválida. Encerrando o programa.")
        return
    }

    val result: Double =
            when (option) {
                1 -> celciusToFahrenheit(temperature)
                2 -> fahrenheitToCelcius(temperature)
                else -> 0.0
            }

    val originalUnit = if (option == 1) "Cº" else "Fº"
    val convertedUnit = if (option == 1) "Fº" else "Cº"

    println("$temperature$originalUnit é igual a $result$convertedUnit")
}
