package com.vds.mycocktail.repository

import com.vds.mycocktail.model.Ingredient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface IngredientRepository : JpaRepository<Ingredient, Long> {
    @Query(value = "SELECT I.* FROM ingredient I WHERE I.type_ingredient = ?1 ORDER BY nom_ingredient", nativeQuery = true)
    fun findAllByTypeOrderByName(type: String): List<Ingredient>
}