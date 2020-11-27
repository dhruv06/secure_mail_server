package com.nss.assignment.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan("com.nss.assignment")
@PropertySources({ //
		@PropertySource(value = "file:./nss.properties", ignoreResourceNotFound = true) //
})
public class SpringConfig {


}
