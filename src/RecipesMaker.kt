fun main(args: Array<String>) {

    var response: String?

    do {
        response = init()
        when(response) {
            "1" -> println("Has seleccionado hacer una receta")
            "2" -> println("Has seleccionado ver tus recetas")
            "3" -> println("Saliendo del programa...")
            else -> println("La opción seleccionada no está entre las posibles, inténtalo de nuevo")
        }
    } while (response != "3")
}

private fun init(): String? {
    val title: String = """
    :: Bienvenido a Recipe Maker ::
    
    Selecciona la opción deseada
    1. Hacer una receta
    2. Ver mis recetas
    3. Salir
    """.trimIndent()

    println(title)

    var response: String?
    response = readLine() ?: "0"
    return response
}