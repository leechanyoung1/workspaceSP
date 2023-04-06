package com.itwill.security.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)//Spring Security를 사용하도록 설정합니다. debug 옵션을 true로 설정하여 디버그 모드로 동작하도록 합니다.
@EnableGlobalMethodSecurity(prePostEnabled = true)
/*
 * @EnableGlobalMethodSecurity(prePostEnabled = true) 어노테이션은 메서드 단위의 보안 구성을 활성화하며,
 *  @PreAuthorize, @PostAuthorize 어노테이션과 같은 보안 어노테이션을 사용할 수 있도록 합니다.
	prePostEnabled = true는 @PreAuthorize, @PostAuthorize 어노테이션을 사용할 수 있도록 합니다.
 */
public class SecurityConfig2 extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {//인증에 관련된 설정을 합니다. 이 예제에서는 인메모리 방식으로 사용자를 생성합니다.
		auth.inMemoryAuthentication()
			.withUser(User.builder().username("user2").password( passwordEncoder().encode("2222")).roles("USER"))//withUser() 메소드를 사용하여 계정 정보를 설정하며, User.builder() 메소드를 호출하여 UserDetails 객체를 생성합니다.
			.withUser(User.builder().username("admin").password(passwordEncoder().encode("3333")).roles("ADMIN"));//encode() 메소드를 사용하여 비밀번호를 암호화합니다.
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*
	 * PasswordEncoder는 Spring Security에서 사용자의 비밀번호를 암호화하거나 인코딩할 때 사용됩니다.
		BCryptPasswordEncoder는 사용자의 비밀번호를 안전하게 암호화하는 방법 중 하나입니다.
		passwordEncoder() 메소드는 Bean으로 등록되어 있으며, BCryptPasswordEncoder 객체를 반환합니다. 
		이를 통해, 인증 과정에서 사용자의 비밀번호를 암호화하거나 인코딩할 때 사용할 수 있습니다.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {//HttpSecurity 객체를 사용하여 인증 및 권한 부여를 구성합니다. "/login" 페이지를 제공하며, 로그인/로그아웃 처리, CSRF, CORS 등을 설정합니다.
		//http.authorizeHttpRequests().anyRequest().permitAll();
		http.authorizeHttpRequests().antMatchers("/","/auth","/login").permitAll();
		/*
		 * http.authorizeHttpRequests() 메소드를 사용하여 요청에 대한 인증을 구성합니다.

		   antMatchers() 메소드를 사용하여 특정 요청 경로에 대한 권한 설정을 합니다.
			
		   authenticated() 메소드를 사용하여 인증된 사용자만 해당 요청 경로에 접근할 수 있도록 합니다.
		 */
		http.authorizeHttpRequests().anyRequest().authenticated();
		http.formLogin()//formLogin() 메소드를 사용하여 로그인 페이지 및 로그인/로그아웃 처리를 설정합니다.
		.loginPage("/login")
		//loginPage("/login") 메소드는 로그인 페이지를 지정합니다. 이 메소드를 사용하면 기본 로그인 페이지 대신 커스텀 로그인 페이지를 사용할 수 있습니다.
		.loginProcessingUrl("/login")
		//loginProcessingUrl("/login") 메소드는 로그인 처리를 담당하는 URL을 지정합니다. 즉, 로그인 버튼이 클릭되면 이 URL로 POST 요청을 보내게 됩니다.
		.defaultSuccessUrl("/")
		//defaultSuccessUrl("/") 메소드는 로그인 성공 시 이동할 URL을 지정합니다. 이 경우, 로그인 성공 후에는 애플리케이션의 루트 페이지로 이동하게 됩니다.
		.failureUrl("/login-error");
		//failureUrl("/login-error") 메소드는 로그인 실패 시 이동할 URL을 지정합니다. 이 경우, 로그인 실패 후에는 "/login-error" 페이지로 이동하게 됩니다.
		
		http.logout().logoutSuccessUrl("/");
		/*
		 * logout() 메소드는 로그아웃 처리를 담당합니다.
			logoutSuccessUrl("/") 메소드는 로그아웃 성공 시 이동할 URL을 지정합니다.
			 이 경우, 로그아웃 후에는 애플리케이션의 루트 페이지로 이동하게 됩니다.
		 */
		http.exceptionHandling().accessDeniedPage("/access-denied");
		/*
		 *  exceptionHandling() 메소드는 예외 처리를 담당합니다.
			accessDeniedPage("/access-denied") 메소드는 인증은 성공했지만 
			권한 부족으로 인해 접근이 거부될 경우 이동할 URL을 지정합니다. 
			이 경우, "/access-denied" 페이지로 이동하게 됩니다.
		 */
		http.httpBasic();//httpBasic() 메소드를 사용하여 Http Basic 인증을 활성화합니다.
		/*
		http.formLogin().disable()
			.httpBasic().disable()
			.cors().disable()
			.csrf().disable()
			.headers().disable()
			.anonymous().disable()
			.logout().disable()
			.requestCache().disable()
			.sessionManagement().disable()
			.securityContext().disable()
			.exceptionHandling().disable();
		*/	
			
	}
	/*
	 * @Bean RoleHierarchy roleHierarchy() { RoleHierarchyImpl roleHierarchy = new
	 * RoleHierarchyImpl(); roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");
	 * return roleHierarchy; }
	 */
	
	
	
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {//WebSecurity 객체를 사용하여 웹 보안을 구성합니다. 이 예제에서는 정적 리소스에 대한 보안 설정을 무시하도록 합니다.
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		/*
		 * ignoring() 메소드는 보안 필터링에서 제외할 요청을 구성하는 메소드입니다.
			requestMatchers(PathRequest.toStaticResources().atCommonLocations()) 메소드는 
			정적 리소스가 위치한 경로를 구성합니다. 이 경우, 정적 리소스를 필터링하지 않습니다.
		 */
	}
	
}
