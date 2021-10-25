package com.react_forum.kotlincore.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = arrayOf("com.react_forum.kotlincore.data_access")
class DataConfig


