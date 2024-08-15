package org.gsc.security;

import org.gsc.constant.GscConstants;
import org.gsc.medha.service.impl.GscSecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// @EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Autowired
    private GscSecurityUserDetailsService gscSecurityUserDetailsService;

    private final String LOGIN_URL = GscConstants.LOGIN_CONTROLLER_PATH + GscConstants.LOGIN_CONTROLLER_LOGIN_PATH;
    private final String PROCESS_LOGIN_URL = GscConstants.LOGIN_CONTROLLER_PATH
            + GscConstants.LOGIN_CONTROLLER_DO_LOGIN_PATH;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize -> authorize
                // .requestMatchers(GscConstants.HOMEPAGE_PATH, LOGIN_URL,
                // "/views/*.jsp","/medhasandhan/*","/views/medha/*.jsp").permitAll()
                .requestMatchers(GscConstants.HOMEPAGE_PATH,LOGIN_URL,PROCESS_LOGIN_URL+"?*", "/views/*.jsp")
                
                .permitAll()
                // .requestMatchers("/medhasandhan/*", "/views/medha/*.jsp")
                // .hasRole("ADMIN")
                .anyRequest()
                .authenticated())
                .formLogin(formLogin -> formLogin
                                .loginPage(LOGIN_URL)
                                .permitAll()
                                .loginProcessingUrl(PROCESS_LOGIN_URL)
                                //.failureForwardUrl(LOGIN_URL)
                                .defaultSuccessUrl("/medhasandhan",true)
                                .usernameParameter("id")
                                .passwordParameter("password"))
                .logout(logout -> logout.permitAll());

        return http.build();
    }

    // @Bean
    // public HttpFirewall allowDoubleSlashHttpFirewall() {
    // StrictHttpFirewall firewall = new StrictHttpFirewall();
    // firewall.setAllowUrlEncodedSlash(true);
    // // firewall.setallowf
    // return firewall;
    // }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(this.passwordEncoder());
        authenticationProvider.setUserDetailsService(gscSecurityUserDetailsService);
        return authenticationProvider;
    }
}
