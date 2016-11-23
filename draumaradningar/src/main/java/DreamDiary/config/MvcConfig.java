package DreamDiary.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@EnableWebMvc
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");

        
    }
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