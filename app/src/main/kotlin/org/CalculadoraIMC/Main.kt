package org.CalculadoraIMC

fun main() {
    println("=== Calculadora de IMC ===")

    print("Digite seu peso (kg): ")
    val peso = readLine()?.toDoubleOrNull()
    if (peso == null || peso <= 0) {
        println("Peso inválido.")
        return
    }

    print("Digite sua altura (m): ")
    val altura = readLine()?.toDoubleOrNull()
    if (altura == null || altura <= 0) {
        println("Altura inválida.")
        return
    }

    val imc = calcularIMC(peso, altura)
    val classificacao = classificarIMC(imc)

    println("Seu IMC é: ${"%.2f".format(imc)}")
    println("Classificação: $classificacao")
}

fun calcularIMC(peso: Double, altura: Double): Double {
    return peso / (altura * altura)
}

fun classificarIMC(imc: Double): String {
    return when {
        imc < 18.5 -> "Abaixo do peso"
        imc < 25.0 -> "Peso normal"
        imc < 30.0 -> "Sobrepeso"
        imc < 35.0 -> "Obesidade Grau 1"
        imc < 40.0 -> "Obesidade Grau 2"
        else -> "Obesidade Grau 3"
    }
}
