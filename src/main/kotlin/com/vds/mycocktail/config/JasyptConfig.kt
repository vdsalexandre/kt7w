package com.vds.mycocktail.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource(value = ["classpath:/config/encrypted.properties"])
open class JasyptConfig { }