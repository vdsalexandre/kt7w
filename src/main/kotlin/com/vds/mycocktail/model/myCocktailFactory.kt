package com.vds.mycocktail.model

val anEmptyCocktail = Cocktail(
    idCocktail = -1,
    nomCocktail = "",
    recetteCocktail = "",
    ingredients = listOf(),
)

val anEmptyIngredient = Ingredient(
    idIngredient = -1,
    nomIngredient = "",
    typeIngredient = "",
    cocktails = listOf()
)