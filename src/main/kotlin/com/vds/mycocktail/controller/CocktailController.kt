package com.vds.mycocktail.controller

import com.vds.mycocktail.config.ServerUrls.REQUEST_COCKTAIL
import com.vds.mycocktail.model.Cocktail
import com.vds.mycocktail.model.anEmptyCocktail
import com.vds.mycocktail.repository.CocktailRepository
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(REQUEST_COCKTAIL)
class CocktailController {
    companion object {
        private val LOGGER = LogManager.getLogger()
    }

    @Autowired
    lateinit var cocktailRepository: CocktailRepository

    @GetMapping("/all")
    fun findAllCocktails(): List<Cocktail> {
        LOGGER.info("GET: $REQUEST_COCKTAIL/all")
        return cocktailRepository.findAll()
    }

    @GetMapping("/{id}")
    fun findCocktailById(@PathVariable("id") id: Long): Cocktail {
        LOGGER.info("GET: $REQUEST_COCKTAIL/$id")
        return cocktailRepository.findById(id).orElse(anEmptyCocktail)
    }

    @GetMapping("/contains/{ingredientIds}")
    fun findCocktailsContainingTheseIngredients(@PathVariable("ingredientIds") ingredientIds: List<Long>): List<Cocktail> {
        LOGGER.info("GET: $REQUEST_COCKTAIL/contains -> $ingredientIds")
        return cocktailRepository.findCocktailsContainingTheseIngredients(ingredientIds, ingredientIds.size)
    }

    @PostMapping("/add")
    fun saveCocktail(@RequestBody cocktail: Cocktail) {
        LOGGER.info("POST: $REQUEST_COCKTAIL/add -> $cocktail")
        cocktailRepository.save(cocktail)
    }

    @DeleteMapping("/del/{id}")
    fun delCocktail(@PathVariable("id") id: Long) {
        LOGGER.info("DELETE: $REQUEST_COCKTAIL/del/$id")
        cocktailRepository.deleteById(id)
    }

    @PutMapping("/update")
    fun updateCocktail(@RequestBody cocktail: Cocktail) {
        LOGGER.info("PUT: $REQUEST_COCKTAIL/update -> $cocktail")
        cocktailRepository.save(cocktail)
    }
}