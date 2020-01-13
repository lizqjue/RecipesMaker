fun main(args: Array<String>) {

    var response: String?

    do {
        response = init()
        when(response) {
            "1" -> {
                println("Has seleccionado hacer una receta")
                makeRecipe()
            }
            "2" -> {
                println("Has seleccionado ver tus recetas")
                viewRecipe({readLine() ?: "0"}())
            }
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

private fun makeRecipe() {
    {println("""
        Hacer receta
        Selecciona por categoría el ingrediente que buscas
        1. Agua
        2. Leche
        3. Carne
        4. Verduras
        5. Frutas
        6. Cereal
        7. Huevos
        8. Aceites
    """)}()
}

private fun viewRecipe(category: String) {
    println({ category: String -> when(category) {
        "1" -> "Agua"
        "2" -> "Leche"
        "3" -> "Carne"
        "4" -> "Verduras"
        "5" -> "Frutas"
        "6" -> "Cereal"
        "7" -> "Huevos"
        "8" -> "Aceites"
        else -> "La categoría no existe"}
        }(category))
}