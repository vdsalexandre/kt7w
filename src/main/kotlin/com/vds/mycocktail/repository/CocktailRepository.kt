package com.vds.mycocktail.repository

import com.vds.mycocktail.model.Cocktail
import com.vds.mycocktail.sql.DbQueries.FIND_COCKTAILS_CONTAINING_THESE_INGREDIENTS
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CocktailRepository : CrudRepository<Cocktail, Long> {

    @Query(value = FIND_COCKTAILS_CONTAINING_THESE_INGREDIENTS, nativeQuery = true)
    fun findCocktailsContainingTheseIngredients(ingredientIds: List<Long>, numberOfIngredients: Int): Set<Cocktail>
}