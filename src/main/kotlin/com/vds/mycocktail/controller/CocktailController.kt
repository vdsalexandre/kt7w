package com.vds.mycocktail.controller

import com.vds.mycocktail.model.Cocktail
import com.vds.mycocktail.repository.CocktailRepository
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/mycocktail")
class CocktailController {
    companion object {
        private val LOGGER = LogManager.getLogger()
    }

    @Autowired
    lateinit var cocktailRepository: CocktailRepository

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
}