package com.vds.mycocktail.repository

import com.vds.mycocktail.model.Cocktail
import org.springframework.data.jpa.repository.JpaRepository

interface CocktailRepository : JpaRepository<Cocktail, Long> { }