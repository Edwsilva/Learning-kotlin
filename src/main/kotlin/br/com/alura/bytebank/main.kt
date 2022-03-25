package br.com.alura.bytebank

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.modelo.SistemaInterno
import br.com.alura.bytebank.teste.soma

fun main() {
//    val endereco = Endereco(logradouro = "rua vergueiro", numero = 3185)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

    // o let sempre terá sua chamada a partir de um objeto.
    // ele implementa generics it{Int} int{String} int{object}
    // Função dentro de outra função
    // fun teste(bloco: () -> Unit) {

    // }


    Endereco(logradouro = "rua vergueiro", numero = 3185)
        .let { endereco ->
            "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
        }.let(::println)

    listOf(Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "apartamento"))
        .filter (predicate = { endereco -> endereco.complemento.isNotEmpty() })
        .let(block = (::println))

    soma(1, 5, resultado = (::println))

    val autenticavel = object : Autenticavel {
        val senha = 1234
        override fun autentica(senha: Int) = this.senha == senha
    }

    SistemaInterno().entra(autenticavel, 1234, autenticado = {
        println("realizar pagamento")
    })
    teste{}

}

fun soma(a: Int, b: Int, resultado: (Int) -> Unit) {
    println("antes da soma")
    resultado(a + b)
    println("depois da soma")
}

// Função dentro de outra função. Na chamada ela usa expressão lambda
// teste{}
 fun teste(bloco: () -> Unit) {
    println("teste")
 }