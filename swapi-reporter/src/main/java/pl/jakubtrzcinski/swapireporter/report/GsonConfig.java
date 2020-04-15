package pl.jakubtrzcinski.swapireporter.report;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GsonConfig {
    @Bean
    Gson getGson(){
        return new Gson();
    }
}
