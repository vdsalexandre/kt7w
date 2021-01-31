package com.vds.mycocktail.controller

import com.vds.mycocktail.model.Ingredient
import com.vds.mycocktail.repository.IngredientRepository
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
import java.util.Optional
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/mycocktail/ingredient")
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
        LOGGER.info("GET: /ingredient/all")
        return ingredientRepository.findAll()
    }

    @GetMapping("/{id}")
    fun findIngredientById(@PathVariable("id") id: Long): Optional<Ingredient> {
        LOGGER.info("GET: /ingredient/$id")
        return ingredientRepository.findById(id)
    }

    @GetMapping("/all/{type}")
    fun findAllIngredientsByType(@PathVariable("type") type: String): List<Ingredient> {
        LOGGER.info("GET: /ingredient/all/$type - FROM: ${request.remoteAddr}")
        return ingredientRepository.findAllByTypeOrderByName(type)
    }

    @PostMapping("/add")
    fun saveIngredient(@RequestBody ingredient: Ingredient) {
        LOGGER.info("POST: /ingredient/add -> $ingredient")
        ingredientRepository.save(ingredient)
    }

    @DeleteMapping("/del/{id}")
    fun deleteIngredient(@PathVariable("id") id: Long) {
        LOGGER.info("DELETE: /ingredient/del/$id")
        ingredientRepository.deleteById(id)
    }

    @PutMapping("/update")
    fun updateIngredient(@RequestBody ingredient: Ingredient) {
        LOGGER.info("PUT: /ingredient/update -> $ingredient")
        ingredientRepository.save(ingredient)
    }
}