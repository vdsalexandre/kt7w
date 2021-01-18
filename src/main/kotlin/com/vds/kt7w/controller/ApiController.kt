package com.vds.kt7w.controller

import com.vds.kt7w.model.Cocktail
import com.vds.kt7w.model.Ingredient
import com.vds.kt7w.repository.CocktailRepository
import com.vds.kt7w.repository.IngredientRepository
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/mycocktail")
class ApiController {
    companion object {
        private val LOGGER = LogManager.getLogger()
    }

    @Autowired
    lateinit var cocktailRepository: CocktailRepository

    @Autowired
    lateinit var ingredientRepository: IngredientRepository

    @GetMapping("/cocktail/all")
    fun findAllCocktails(): List<Cocktail> {
        LOGGER.info("GET: /cocktail/all")
        return cocktailRepository.findAll()
    }

    @GetMapping("/cocktail/{id}")
    fun findCocktailById(@PathVariable("id") id: Long): Optional<Cocktail> {
        LOGGER.info("GET: /cocktail/$id")
        return cocktailRepository.findById(id)
    }

    @GetMapping("/ingredient/all")
    fun findAllIngredients(): List<Ingredient> {
        LOGGER.info("GET: /ingredient/all")
        return ingredientRepository.findAll()
    }

    @GetMapping("/ingredient/{id}")
    fun findIngredientById(@PathVariable("id") id: Long): Optional<Ingredient> {
        LOGGER.info("GET: /ingredient/$id")
        return ingredientRepository.findById(id)
    }

    @GetMapping("/ingredient/all/{type}")
    fun findAllIngredientsByType(@PathVariable("type") type: String): List<Ingredient> {
        LOGGER.info("GET: /ingredient/all/$type")
        return ingredientRepository.findAllByType(type)
    }

    @PostMapping("/ingredient/add")
    fun saveIngredient(@RequestBody ingredient: Ingredient) {
        LOGGER.info("POST: /ingredient/add -> $ingredient")
        ingredientRepository.save(ingredient)
    }

    @DeleteMapping("/ingredient/del/{id}")
    fun deleteIngredient(@PathVariable("id") id: Long) {
        LOGGER.info("DELETE: /ingredient/del/$id")
        ingredientRepository.deleteById(id)
    }
}