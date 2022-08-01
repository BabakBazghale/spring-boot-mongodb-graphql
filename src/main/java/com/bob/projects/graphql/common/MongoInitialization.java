package com.bob.projects.graphql.common;

import com.bob.projects.graphql.model.Music;
import com.bob.projects.graphql.model.Singer;
import com.bob.projects.graphql.repository.SingerRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

@Configuration
public class MongoInitialization {
    private final static String[] GENDERS = {"male", "female", "she-male"};
    private final static String[] SINGERS_NAMES = {"Lady Gaga", "Justin Bieber", "Lana Del Rey","Michael Jackson",
            "Elvis Presley","Shawn Mendes","Adele"};
    private static final Faker faker = new Faker();
    @Autowired
    private SingerRepository singerRepository;

    public static Singer singerGeneration() {
        Random random = new Random();
        return Singer.builder()
                .name(SINGERS_NAMES[random.nextInt(SINGERS_NAMES.length)])
                .age(random.nextInt(10 - 1 + 1) + 1)
                .gender(GENDERS[random.nextInt(GENDERS.length)])
                .thumbnail(UUID.randomUUID().toString())
                .musics(Collections.singletonList(
                        Music.builder().genre(faker.music().genre())
                                .instrument(faker.music().instrument())
                                .chord(faker.music().chord()).build())).build();
    }

    public static Singer singerGenerationWithInput(String name, Integer age, String gender) {
        return Singer.builder()
                .name(name)
                .age(age)
                .gender(gender)
                .thumbnail(UUID.randomUUID().toString())
                .musics(Collections.singletonList(
                        Music.builder().genre(faker.music().genre())
                                .instrument(faker.music().instrument())
                                .chord(faker.music().chord()).build())).build();
    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < 5; i++) {
            singerRepository.save(singerGeneration());
        }
    }


}
