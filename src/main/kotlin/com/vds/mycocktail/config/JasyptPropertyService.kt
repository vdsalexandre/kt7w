package com.vds.mycocktail.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class JasyptPropertyService() {
    @Value("\${spring.datasource.password}")
    val property: String = ""
}