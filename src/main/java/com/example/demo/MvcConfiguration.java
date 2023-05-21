package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration {
	@Profile("prod")
    @Configuration
    public static class ProdMvcConfiguration implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
                    .addResourceLocations("classpath:/templates/", "classpath:/static/")
                    .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
        }
    }

    @Profile("local")
    @Configuration
    public static class LocalMvcConfiguration implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/**")
                    .addResourceLocations("file:src/main/resources/templates/", "file:src/main/resources/static/"
                    		,"file:src/main/resources/META-INF/views");
        }
    }
}
