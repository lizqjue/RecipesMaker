import model.Food
import model.Recipe


val recipesList: MutableList<Recipe> = mutableListOf()
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
                viewRecipe()
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

    var foodList: MutableList<Food> = mutableListOf()

    do {
        {
            println(
                """
            Selecciona por categoría el ingrediente que buscas
            1. Agua
            2. Leche
            3. Carne
            4. Verduras
            5. Frutas
            6. Cereal
            7. Huevos
            8. Aceites
            
            Para finalizar la receta, escribe 0
        """
            )
        }()

        var optionSelected = { readLine() ?: "0" }()

        if (optionSelected == "0") {
            break
        }

        val listedCategory = showIngredientsList(optionSelected);

        addIngredient(listedCategory, foodList)

    } while(optionSelected != "0")

    recipesList.add(Recipe("Recipe number ${recipesList.size + 1}", foodList))

    println("Receta añadida!")
}

private fun addIngredient(
    listedCategory: List<String>,
    foodList: MutableList<Food>
) {
    println("Choose an ingredient to add it to the recipe:")
    val ingredientIndex: Int = { readLine() ?: "0" }().toInt()

    if (ingredientIndex <= listedCategory.size) {
        foodList.add(Food(1, listedCategory[ingredientIndex - 1]))
        println("Ingredient ${listedCategory[ingredientIndex - 1]} added")
    } else {
        println("The ingredient is not in the list, please enter the number of an ingredient from the list")
    }
}

fun showIngredientsList(category: String): List<String> {

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
        else -> println("Opción incorrecta, introduce un número del 1 al 8")
    }

    for ((index, foodElement) in foodList.withIndex()) {
        println("${index + 1}. $foodElement")
    }

    return foodList
}

private fun viewRecipe() {

    println("Recetas disponibles:")

    for (recipe in recipesList) {
        println("""
            ${recipe.name}
        """.trimIndent());
    }

    println("Select a recipe:")

    val recipeSelectedIndex = {readLine() ?: "0" }().toInt()

    if (recipeSelectedIndex <= recipesList.size) {
        println("${recipesList[recipeSelectedIndex - 1].name}")
        val selectedRecipe = recipesList[recipeSelectedIndex - 1]
        for(food in selectedRecipe.recipeIngredients) {
            println("""
                ${food.name} - quantity: ${food.quantity}
            """.trimIndent())
        }
    } else {
        println("La receta $recipeSelectedIndex no está disponible")
    }
}