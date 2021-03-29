package com.vds.mycocktail.controller

import com.vds.mycocktail.config.ServerUrls.REQUEST_INGREDIENT
import com.vds.mycocktail.model.Ingredient
import com.vds.mycocktail.model.anEmptyIngredient
import com.vds.mycocktail.repository.IngredientRepository
import javax.servlet.http.HttpServletRequest
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
@RequestMapping(REQUEST_INGREDIENT)
class IngredientController {
    companion object {
        private val LOGGER = LogManager.getLogger()
    }

    @Autowired
    lateinit var ingredientRepository: IngredientRepository

    @Autowired
    lateinit var request: HttpServletRequest

    @GetMapping("/all")
    fun findAllIngredients(): List<Ingredient> {
        LOGGER.info("GET: $REQUEST_INGREDIENT/all")
        return ingredientRepository.findAll()
    }

    @GetMapping("/{id}")
    fun findIngredientById(@PathVariable("id") id: Long): Ingredient {
        LOGGER.info("GET: $REQUEST_INGREDIENT/$id")
        return ingredientRepository.findById(id).orElse(anEmptyIngredient)
    }

    @GetMapping("/all/{type}")
    fun findAllIngredientsByType(@PathVariable("type") type: String): List<Ingredient> {
        LOGGER.info("GET: $REQUEST_INGREDIENT/all/$type - FROM: ${request.remoteAddr}")
        return ingredientRepository.findAllByTypeOrderByName(type)
    }

    @PostMapping("/add")
    fun saveIngredient(@RequestBody ingredient: Ingredient) {
        LOGGER.info("POST: $REQUEST_INGREDIENT/add -> $ingredient")
        ingredientRepository.save(ingredient)
    }

    @DeleteMapping("/del/{id}")
    fun deleteIngredient(@PathVariable("id") id: Long) {
        LOGGER.info("DELETE: $REQUEST_INGREDIENT/del/$id")
        ingredientRepository.deleteById(id)
    }

    @PutMapping("/update")
    fun updateIngredient(@RequestBody ingredient: Ingredient) {
        LOGGER.info("PUT: $REQUEST_INGREDIENT/update -> $ingredient")
        ingredientRepository.save(ingredient)
    }
}