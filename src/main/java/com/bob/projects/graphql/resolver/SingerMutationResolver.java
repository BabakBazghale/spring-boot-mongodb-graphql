package com.bob.projects.graphql.resolver;

import com.bob.projects.graphql.common.MongoInitialization;
import com.bob.projects.graphql.repository.SingerRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.bob.projects.graphql.model.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingerMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private SingerRepository singerRepository;

    public Singer singerPersistence( String name, Integer age,  String gender) {
        return singerRepository.save(MongoInitialization
                .singerGenerationWithInput(name,age,gender));
    }
}
