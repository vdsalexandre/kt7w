package com.vds.mycocktail.repository

import com.vds.mycocktail.model.Cocktail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CocktailRepository : JpaRepository<Cocktail, Long> {

    @Query(value = "SELECT DISTINCT C.* FROM composer O JOIN ingredient I ON O.id_ingredient = I.id_ingredient " +
                    "JOIN cocktail C ON C.id_cocktail = O.id_cocktail WHERE O.id_ingredient IN ?1 " +
                    "GROUP BY C.id_cocktail HAVING COUNT (DISTINCT O.id_ingredient) = ?2", nativeQuery = true)
    fun findCocktailsContainingTheseIngredients(ingredientIds: List<Long>, numberOfIngredients: Int): List<Cocktail>
}