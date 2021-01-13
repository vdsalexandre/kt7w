package com.vds.kt7w.controller

import com.vds.kt7w.model.Hello
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicInteger

@RestController
@RequestMapping("/7w")
class ApiController {

    val index = AtomicInteger();

    @GetMapping("/hello/{name}")
    fun home(@PathVariable("name") name: String) =
        Hello(index.incrementAndGet(), "Hello $name !")
}