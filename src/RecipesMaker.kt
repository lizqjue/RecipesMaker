


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
    } while (response != "3" || response != "1")
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
    showIngredientsList({readLine() ?: "0"}());
}

fun showIngredientsList(category: String) {

    var foodList: List<String> = listOf()

    when(category) {
        "1" -> foodList = listOf("agua")
        "2" -> foodList = listOf("Leche","Queso","Yogur")
        "3" -> foodList = listOf("Res","Pollo","Pescado","Cerdo")
        "4" -> foodList = listOf("Tomate","Zanahoria","Cebolla","Pepino","Lechuga")
        "5" -> foodList = listOf("Fresa","Plátano","Uvas","Manzana","Naranja","Pera","Cereza")
        "6" -> foodList = listOf("Avena", "Trigo", "Arroz","Maiz")
        "7" -> foodList = listOf("Huevos")
        "8" -> foodList = listOf("Mantequilla","Aceite oliva")
        else -> println("Opción incorrecta")
    }

    for ((index, foodElement) in foodList.withIndex()) {
        println("${index + 1}. $foodElement")
    }
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