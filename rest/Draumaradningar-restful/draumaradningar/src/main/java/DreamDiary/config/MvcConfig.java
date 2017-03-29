package DreamDiary.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter  {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/","login");
      
    }

}