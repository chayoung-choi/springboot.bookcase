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
       web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
   }
   
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
           .csrf().disable()
           .headers().frameOptions().disable() 
           .and()
               .authorizeRequests()
               .antMatchers("/", "/login", "/sample/**").permitAll()
               .antMatchers("/api/v1/**").hasAnyAuthority("ROLE_USER","ROLE_ADMIN")
//               .antMatchers("/api/v1/**").hasRole().
               .anyRequest().authenticated()
           .and()
               .logout()
                   .logoutSuccessUrl("/")
           .and()
               .oauth2Login()
               .loginPage("/login")
                   .userInfoEndpoint()	// OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                       .userService(customOAuth2UserService);	// 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록합니다.
   }
   
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}