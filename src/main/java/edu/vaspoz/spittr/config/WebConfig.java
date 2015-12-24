package edu.vaspoz.spittr.config;

import edu.vaspoz.spittr.Spittle;
import edu.vaspoz.spittr.data.SpittleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vasilii_Pozdeev on 23-Dec-15.
 */
@Configuration
@EnableWebMvc
@ComponentScan("edu.vaspoz.spittr.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;

    }


    // Just mock-repo
    @Bean
    public SpittleRepository spittleRepository() {

        return new SpittleRepository() {
            @Override
            public List<Spittle> findSpittles(long max, int count) {
                List<Spittle> spittleList = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    spittleList.add(new Spittle("Spittle " + i, new Date()));
                }
                return spittleList;
            }

            @Override
            public Spittle findOne(long spittleId) {
                return new Spittle("Hi! I`m just a spittle with id = " + spittleId, new Date());
            }
        };

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();

    }
}
