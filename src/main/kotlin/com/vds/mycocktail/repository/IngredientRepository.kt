package com.vds.mycocktail.repository

import com.vds.mycocktail.model.Ingredient
import com.vds.mycocktail.sql.DbQueries.FIND_ALL_INGREDIENTS_BY_TYPE_ORDER_BY_NAME
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface IngredientRepository : CrudRepository<Ingredient, Long> {
    @Query(value = FIND_ALL_INGREDIENTS_BY_TYPE_ORDER_BY_NAME, nativeQuery = true)
    fun findAllByTypeOrderByName(type: String): Set<Ingredient>
}