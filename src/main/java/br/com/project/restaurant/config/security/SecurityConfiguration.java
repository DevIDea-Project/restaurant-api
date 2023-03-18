package br.com.project.restaurant.config.security;

import br.com.project.restaurant.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthService authservice;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager () throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authservice).passwordEncoder(new BCryptPasswordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/auth").permitAll()

			.antMatchers(HttpMethod.POST, "/usuario/perfil").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.POST, "/usuario").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.GET, "/usuario").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.GET, "/usuario/*").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/usuario/*").hasAnyAuthority("ADMIN")

			.antMatchers(HttpMethod.POST, "/pedido").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.PUT, "/pedido/*").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.GET, "/pedido").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.GET, "/pedido/*").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/pedido/*").hasAnyAuthority("ADMIN")

			.antMatchers(HttpMethod.POST, "/cardapio").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.PUT, "/cardapio/*").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.GET, "/cardapio").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.GET, "/cardapio/*").hasAnyAuthority("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/cardapio/*").hasAnyAuthority("ADMIN")

			.anyRequest().authenticated()
			.and().cors().and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().addFilterBefore(new AuthenticationToken(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
	}
}
 