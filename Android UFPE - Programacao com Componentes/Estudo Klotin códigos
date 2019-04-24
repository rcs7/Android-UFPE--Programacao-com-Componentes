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
