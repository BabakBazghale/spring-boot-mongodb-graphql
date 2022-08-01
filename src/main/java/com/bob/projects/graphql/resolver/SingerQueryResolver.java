package com.bob.projects.graphql.resolver;

import com.bob.projects.graphql.model.Singer;
import com.bob.projects.graphql.repository.SingerRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SingerQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private SingerRepository singerRepository;

    public Optional<Singer> getSingers(String singerId) {
        return singerRepository.findById(singerId);
    }

    public List<Singer> singers() {
        return singerRepository.findAll();
    }
}
