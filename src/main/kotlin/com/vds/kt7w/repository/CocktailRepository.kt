package com.vds.kt7w.repository

import com.vds.kt7w.model.Cocktail
import org.springframework.data.jpa.repository.JpaRepository

interface CocktailRepository : JpaRepository<Cocktail, Long> { }