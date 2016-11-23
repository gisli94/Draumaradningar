package DreamDiary.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/login", "/newUser", "/guestDream", "/diary").permitAll()
				.antMatchers("/dream").hasRole("USER")	
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")//.failureUrl("/login/$error$")
				.defaultSuccessUrl("/dream")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
	
	
	
	//@Autowired
	//DataSource dataSource;
	
	//User authentication configurations:
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
				
		//For using when connected to real database
		/*import javax.sql.DataSource;

		  auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
				"select username,password, enabled from users where username=?");
		*/
    }
}