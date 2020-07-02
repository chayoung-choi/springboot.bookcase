package com.cyoung90.bookcase.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cyoung90.bookcase.domain.user.Role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   private final CustomOAuth2UserService customOAuth2UserService;

   @Override
   public void configure(WebSecurity web) throws Exception
   {
       // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
       web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/api/v1/**");
   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
           .csrf().disable()
           .headers().frameOptions().disable() 
           .and()
               .authorizeRequests()
               .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/sample/**").permitAll()
               .antMatchers("/api/v1/**").hasRole(Role.USER.name())
//               .anyRequest().authenticated()
           .and()
               .logout()
                   .logoutSuccessUrl("/")
           .and()
               .oauth2Login()
               .loginPage("/login")
//                   .userInfoEndpoint()
//                       .userService(customOAuth2UserService)
                       ;
   }
   
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}