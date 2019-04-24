	package ch01.ex1_ATasteOfKotlin

//Declarando uma classe com duas propriedades (atributos)
//age é null por default (caso não especificado)
data class Person(val name: String,
                  //nullable type
                  val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(
        				 //construtor, omite age -> null
        				 Person("Alice"),
                         Person(
                             "Bob", 
                             //named arguments
                             age = 29
                         )
                        )

    //Encontra a pessoa mais velha da lista
    //Função recebe uma lambda expression que tem um parâmetro (it)
    //operador Elvis ?: retorna zero se a idade (age) é null
    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")
}

// The oldest is: Person(name=Bob, age=29)


///////////////////////////////////////////////////////////////////////////

package ch02.ex1_1_HelloWorld

//a palavra fun é usada para declarar uma função
//tipo do parâmetro é informado após o nome
//funções não precisam estar dentro de classes (top-level)
//Arrays são classes
//println é forma concisa de escrever System.out.println
//podemos omitir ;
fun main(args: Array<String>) {
    println("Hello, world!")
}

// essa função é void, não retorna nada

///////////////////////////////////////////////////////////////////////////

package ch02.ex1_2_Functions

//tipo de retorno da função vem após o nome e lista de parâmetros
fun max1(a: Int, b: Int): Int {
    //diferente de outras linguagens, o if é uma expressão, que resulta em um valor
    // similar ao operador ternário (a > b) ? a : b
    return if (a > b) a else b
}

//o corpo da função é apenas uma expressão, podemos simplificar a declaração
fun max2(a: Int, b:Int) : Int = if (a>b) a else b

//Devido ao mecanismo de inferência de tipos, podemos omitir o tipo de retorno
fun max3(a: Int, b:Int) = if (a>b) a else b
//isso só funciona para funções cujo corpo consiste em uma expressão
//no caso de blocos, precisamos especificar o tipo de retorno e o statement return

fun main(args: Array<String>) {
    println(max1(1, 2))
    println(max2(1, 2))
    println(max3(1, 2))

    //declarando variáveis
    val question = "The Ultimate Question of Life, the Universe, and Everything"
    val answer = 42
    //tipo foi omitido, mas pode ser explicitamente especificado
    val answer2 : Int = 42
    //declarar uma variável com val sinaliza que é uma referência imutável
    //
    val languages = arrayListOf("Java")
    languages.add("Kotlin")
    //não há problema, pois a referência permanece inalterada, 
    // o que mudou é o conteúdo do objeto para onde se está apontando
    
    //var permite alterar referências, mas o tipo permanece fixo
    var answer3 = 42
    //answer3 = "no answer" //erro de compilação - type mismatch
    
}
//////////////////////////////////////////////////////////////////////////////////////////

package ch02.ex1_4_1_StringTemplates

fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    //String templates - permite referenciar variáveis locais em literais
    //Equivalente a "Hello, " + name + "!", tão eficiente quanto - usa StringBuilder no código compilado
    println("Hello, $name!")

	
////////////////////////////////////////////////////////////////////////////////////////////

package ch02.ex1_4_2_StringTemplates1

fun main(args: Array<String>) {
    if (args.size > 0) {
        //é possível usar expressões mais complexas, basta colocar {}
        println("Hello, ${args[0]}!")
        //pega o primeiro elemento do array
    }
}
///////////////////////////////////////////////////////////////////////////////////////////

package ch02.ex1_4_2_StringTemplates1

fun main(args: Array<String>) {
    if (args.size > 0) {
        //é possível usar expressões mais complexas, basta colocar {}
        println("Hello, ${args[0]}!")
        //pega o primeiro elemento do array
    }
}

//Não imprime nada. Process finish with code 0
////////////////////////////////////////////////////////////////////////////////////////////

package ch02.ex1_4_3_StringTemplates2

fun main(args: Array<String>) {
    //é possível até mesmo aninhar aspas duplas dentro de aspas duplas, 
    // desde que estejam dentro de uma expressão
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")
}

//Imprime Hello, someone!
/////////////////////////////////////////////////////////////////////////////////////////////

package ch02.ex2_1_3_Properties2

class Person(
    //read-only property (gera um atributo e um getter)
    val name: String,
    //writable property (atributo + getter + setter)
    var isMarried: Boolean
)

fun main(args: Array<String>) {
    val person = Person("Bob", true)
    //ao invés de chamar o getter, referenciamos a property diretamente
    println(person.name)
    println(person.isMarried)
    //da mesma forma que getters, usamos setters diretamente na property
    person.isMarried = false
    println(person.isMarried)
}

/// Bob
/// true
// false
////////////////////////////////////////////////////////////////////////////////////////////////

package ch02.ex2_2_CustomAccessors

//Implementação personalizada de um accessor (getter)
class Rectangle(val height: Int, val width: Int) {
    //isSquare não está usando um campo para armazenar o valor, mas sim um custom getter
    // com a implementação fornecida abaixo. O valor é computado ao acessar a propriedade
    val isSquare: Boolean
        get() {
            return height == width
        }
		//Implementação alternativa seria
		//get() =  height == width
		//para chamar de código Java, usamos o método isSquare()
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
    val square = Rectangle(41, 41)
    println(square.isSquare)
}

//false
//true
///////////////////////////////////////////////////////////////////////////////////////////////