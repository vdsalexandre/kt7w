package com.vds.kt7w.repository

import com.vds.kt7w.model.Ingredient
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientRepository : JpaRepository<Ingredient, Long> { }