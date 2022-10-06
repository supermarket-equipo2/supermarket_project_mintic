package com.project.supermarket.productos;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		// registry.addViewController("/").setViewName("forward:/index.htm");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("carrito").setViewName("/carrito.html");
		registry.addViewController("cart").setViewName("/cart.html");
		registry.addViewController("checkout").setViewName("/checkout.html");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**", "/js/**")
				.addResourceLocations("classpath:/static/css/", "classpath:/static/js/");
	}

}