abstract class Pet(var name: String)

class Cat(name:String) : Pet(name)
class Dog(name:String) : Pet(name)
class Fish(name:String) : Pet(name)

// This tells the compiler that T is a generic type.
// It must be a Pet or one of its subtypes
// so we can create contest objecrs that deal with Cars, Dogs or fish
class Contest<T: Pet> {
    // This defines a
    val scores: MutableMap<T, Int> = mutableMapOf()
}

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}


