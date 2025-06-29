package org.AgendaContatos

data class Contact(val name: String, val phone: String, val mail: String)

val contacts = mutableListOf<Contact>()

fun main() {
    println("=== Agenda de Contatos ===")

    while (true) {
        println(
                """
            |1. Adicionar contato
            |2. Listar contatos
            |3. Buscar contato por nome
            |4. Remover contato por nome
            |5. Sair
        """.trimMargin()
        )

        print("Escolha uma opção: ")
        when (readLine()?.trim()) {
            "1" -> createContact()
            "2" -> listContact()
            "3" -> findContactByName()
            "4" -> removeContactByName()
            "5" -> {
                println("Encerrando...")
                break
            }
            else -> println("Opção inválida.\n")
        }
    }
}

fun createContact() {
    print("Nome: ")
    val nome = readLine()?.trim().orEmpty()

    print("Telefone: ")
    val telefone = readLine()?.trim().orEmpty()

    print("E-mail: ")
    val email = readLine()?.trim().orEmpty()

    if (nome.isBlank() || telefone.isBlank() || email.isBlank()) {
        println("Todos os campos são obrigatórios.\n")
        return
    }

    contacts.add(Contact(nome, telefone, email))
    println("Contato adicionado com sucesso!\n")
}

fun listContact() {
    if (contacts.isEmpty()) {
        println("Nenhum contato na agenda.\n")
        return
    }

    println("Contatos cadastrados:")
    contacts.forEachIndexed { index, contact ->
        println("${index + 1}. ${contact.name} - ${contact.phone} - ${contact.mail}")
    }
    println()
}

fun findContactByName() {
    print("Digite o nome para buscar: ")
    val nomeBusca = readLine()?.trim().orEmpty()

    val encontrados = contacts.filter { it.name.contains(nomeBusca, ignoreCase = true) }

    if (encontrados.isEmpty()) {
        println("Nenhum contato encontrado.\n")
    } else {
        println("Contatos encontrados:")
        encontrados.forEach { println("${it.name} - ${it.phone} - ${it.mail}") }
        println()
    }
}

fun removeContactByName() {
    print("Digite o nome do contato a ser removido: ")
    val name = readLine()?.trim().orEmpty()

    val removed = contacts.removeIf { it.name.equals(name, ignoreCase = true) }

    if (removed) {
        println("Contato removido com sucesso!\n")
    } else {
        println("Contato não encontrado.\n")
    }
}
