package com.vds.kt7w

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableEncryptableProperties
open class Kt7wApplication

fun main(args: Array<String>) {
	runApplication<Kt7wApplication>(*args)
}
