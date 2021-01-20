package com.vds.mycocktail

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableEncryptableProperties
open class MyCocktailApplication

fun main(args: Array<String>) {
	runApplication<MyCocktailApplication>(*args)
}
