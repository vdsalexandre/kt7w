package com.vds.mycocktail.controller

import com.vds.mycocktail.config.ServerUrls.REQUEST_MAPPING
import com.vds.mycocktail.config.ServerUrls.SERVER_STATUS_URL
import com.vds.mycocktail.response.Response
import org.apache.logging.log4j.LogManager
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [REQUEST_MAPPING], produces = ["application/json"])
class ApiController {
    companion object {
        private val LOGGER = LogManager.getLogger()
    }

    @GetMapping(SERVER_STATUS_URL)
    fun healthCheck(): ResponseEntity<Response> {
        LOGGER.info("GET: $REQUEST_MAPPING$SERVER_STATUS_URL")
        return ResponseEntity.ok(Response(200, "ApiController is [ ok ]"))
    }
}