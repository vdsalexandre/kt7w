package com.vds.mycocktail.controller

import com.vds.mycocktail.response.Response
import org.apache.logging.log4j.LogManager
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/mycocktail"], produces = ["application/json"])
class ApiController {
    companion object {
        private val LOGGER = LogManager.getLogger()
    }

    @GetMapping("/server/status")
    fun healthCheck(): ResponseEntity<Response> {
        LOGGER.info("GET: /mycocktail/server/status")
        return ResponseEntity.ok(Response(200, "MyCocktail controller is up"))
    }
}