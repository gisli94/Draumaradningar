package DreamDiary.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.context.annotation.Bean;

@EnableWebMvc
@Configuration
//@ComponentScan("DreamDiary")
public class MvcConfig extends WebMvcConfigurerAdapter  {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/login").setViewName("login");
		registry.addRedirectViewController("/","login");

        
    }
	// @Bean
    // public ViewResolver getViewResolver(){
        // InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // resolver.setPrefix("resources/templates/");
        // resolver.setSuffix(".html");
        // return resolver;
    // }
	//For connecting to mysql database
/*	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/userbase");
		 driverManagerDataSource.setUsername("root");
		 driverManagerDataSource.setPassword("root");
		 return driverManagerDataSource;
	}
*/
}