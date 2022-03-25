package br.com.alura.bytebank.teste

fun testaFuncaoAnonima() {
    // - utililizo quando quero deixar claro o(s) parâmetro(s) de entrada e o retorno
    // - maneira mais explícita
    // - sou obrigado a utilizar o return
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a, b): Int {
        return a + b
    }
    println(minhaFuncaoAnonima(20, 10))

    // Inferindo a entrada eu sou obrigado a informar o tipo
    val minhaFuncaoAnonima1 = fun(a: Int, b: Int): Int {
        return a + b
    }
    println(minhaFuncaoAnonima1(220, 1450))

    // Quando utilizamos função anônima não é necessário a label no return
    // Essa implementação é mais explicita
    val calculaBonificacaoAnonima: (salario: Double) -> Double = fun(salario): Double {
        if (salario > 1000.0) {
            return salario + 50
        }
        return salario + 100.0
    }
    println(calculaBonificacaoAnonima(1100.0))
}

fun testaFuncaoLambda() {
//    Expressão lambda e função anônima não podem ser utilizadas em outros pontos
    val minhaExpressaoLambda: () -> Unit = {
        println("Executa lambda")
    }
    val minhaFuncaoAnonima: () -> Unit = fun(){
        println("Executa função anônima")
    }
    println(minhaExpressaoLambda())
    println(minhaFuncaoAnonima())

    val minhaFuncaoLambda: (Int, Int) -> Int = {a, b ->
        a + b
    }

    // expressão com match
    val minhaFuncaoLambda2: (Int, Int) -> Int = {_, b ->
        b + 500
    }

    println(minhaFuncaoLambda(100, 300))
    // A expressãoLambda está inferindo no tipo
    val minhaFuncaoLambda1 = { a: Int, b: Int ->
        a + b
    }
    println(minhaFuncaoLambda1(15, 10))

    // Com it, só permite um retorno. Ele só retorna a última inscrição
    val calculaBonificacaoComIt: (salario: Double) -> Double = {
        // Na expressão lâmbda o retorno sempre vai para a função que está acima.

//        if(it > 1000.0) {
//            return it + 500.0
//        }
        it + 100.0
    }
    // Return em JUMPS - determina return em label´s
    val calculaBonificacaoComIteLabel: (salario: Double) -> Double = lambda@{
        // Na expressão lâmbda o retorno sempre vai para a função que está acima.

        if(it > 1000.0) {
            return@lambda it + 500.0
        }
        // it + 100.0 - pode ser esse retorno também.
        return@lambda it + 100.0
    }

    println(calculaBonificacaoComIteLabel(1000.0))

    // Utilizando um it nomeado
    val calculaBonificacao: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.0) {
            return@lambda salario + 50
        }
        salario + 100.0
    }
    println(calculaBonificacao(1000.0))
}

fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasse: (Int, Int) -> Int = Soma()
    println(minhaFuncaoClasse(10, 10))
}

fun testaTipoFuncaoReferencia() {
    /* Usando variável do tipo função. Ela deve ficar dentro de uma variável
       sempre vai exigir um retorno (Int, Int) -> porém precisa ser inicializada
       elas precisam ter a mesma assinatura

       inicializando a função (Int, Int) -> Int = ::soma
       :: indica que estamos mandando a referência da função
       val minhaFuncao: () -> Unit = ::teste
       val minhaFuncao = ::teste
       fun teste() {}
     */
    val minhaFuncao: (Int, Int) -> Int = ::soma
    println(minhaFuncao(5, 10))
}

fun soma(a: Int, b: Int) : Int {
    return a + b
}
/* fazendo um objeto(classe) para um tipo função
* É obrigado a utilizar o INVOKE
* val minhaFuncaoClasse: (Int, Int) -> Int = Soma()
* val minhaFuncaoClasse = Soma()
*  */

class Soma : (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b
}
