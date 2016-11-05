package DreamDiary;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
 
@Configuration
public class SpringContext {
 
    @Bean
    User user () {
        return new User();
    }
 
    @Bean
    Dream dream () {
        return new Dream();
    }
     @Bean
    PasswordValidator pass () {
        return new PasswordValidator();
    }
}