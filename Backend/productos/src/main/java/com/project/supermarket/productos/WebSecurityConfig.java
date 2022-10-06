package com.project.supermarket.productos;

import com.project.supermarket.productos.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private CustomLoginSucessHandler sucessHandler;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserServiceImpl();
    }

    // @Bean
    // protected UserDetailsService userDetailsService() {
    // UserDetails usuario1 = User
    // .withUsername("Maria")
    // .password("$2a$10$e4abRg7TxkbtfuFMZ2Ut9eYu6.Y/VOSdGDbmi1XY/AuBZM/BIyzv.")
    // .roles("USER")
    // .build();

    // UserDetails usuario2 = User
    // .withUsername("admin")
    // .password("$2a$10$21k9QLX0vdSytZ36T56yHeDwn2y6DiHdJ2k7fCzccV7CuskmNQmEq")
    // .roles("ADMIN")
    // .build();

    // return new InMemoryUserDetailsManager(usuario1, usuario2);
    // }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // URL matching for accessibility
                .antMatchers("/", "/login", "/register", "/CarritoCompras.html", "/static/index.html", "carrito",
                        "/carrito.html", "cart", "/cart.html", "checkout", "/checkout.html")
                .permitAll()
                // .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers("/account/**").hasAnyAuthority("USER")
                .antMatchers("/empleados", "/empleados/*", "/products", "/products/*").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                // form login
                .csrf().disable().formLogin()
                .loginPage("/login")
                .permitAll()
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/", true)
                .successHandler(sucessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                // logout
                .logout().permitAll()
                .logoutSuccessUrl("/?logout")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        // .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        http.authenticationProvider(authenticationProvider());
        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }
}