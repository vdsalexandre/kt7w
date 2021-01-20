package com.vds.mycocktail.repository

import com.vds.mycocktail.model.Ingredient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface IngredientRepository : JpaRepository<Ingredient, Long> {
    @Query(value = "SELECT I.* FROM ingredient I WHERE I.type_ingredient = ?1", nativeQuery = true)
    fun findAllByType(type: String): List<Ingredient>
}