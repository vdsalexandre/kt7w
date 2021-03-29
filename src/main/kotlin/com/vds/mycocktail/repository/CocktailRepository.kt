package com.vds.mycocktail.repository

import com.vds.mycocktail.model.Cocktail
import com.vds.mycocktail.sql.DbQueries.FIND_COCKTAILS_CONTAINING_THESE_INGREDIENTS
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CocktailRepository : JpaRepository<Cocktail, Long> {

    @Query(value = FIND_COCKTAILS_CONTAINING_THESE_INGREDIENTS, nativeQuery = true)
    fun findCocktailsContainingTheseIngredients(ingredientIds: List<Long>, numberOfIngredients: Int): List<Cocktail>
}