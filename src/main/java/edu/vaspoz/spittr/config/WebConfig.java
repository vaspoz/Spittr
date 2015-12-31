package edu.vaspoz.spittr.config;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import edu.vaspoz.spittr.Spitter;
import edu.vaspoz.spittr.Spittle;
import edu.vaspoz.spittr.data.SpitterRepository;
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

            @Override
            public Spittle save(Spittle spittle) {
                return null;
            }
        };

    }


    @Bean
    public SpitterRepository spitterRepository() {

        return new SpitterRepository() {
            @Override
            public Spitter save(Spitter spitter) {
                return null;
            }

            @Override
            public Spitter findByUsername(String username) {
                return null;
            }
        };

    }


    @Bean
    public MongoClient mongod() throws Exception {

        MongodStarter starter = MongodStarter.getDefaultInstance();

        int port = 12345;
        IMongodConfig mongoConfig = new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(port, Network.localhostIsIPv6()))
                .build();

        MongodExecutable mongodExecutable = starter.prepare(mongoConfig);
        mongodExecutable.start();

        MongoClient mongo = new MongoClient("localhost", port);

        DB db = mongo.getDB("test");
        DBCollection col = db.createCollection("collection", new BasicDBObject());
        col.insert(new BasicDBObject("key", "value"));
        col.insert(new BasicDBObject("key1", "value1"));
        col.insert(new BasicDBObject("key2", "value2"));

        return mongo;

    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();

    }
}
