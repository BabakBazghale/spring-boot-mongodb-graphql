package com.bob.projects.graphql.resolver;

import com.bob.projects.graphql.model.Singer;
import com.bob.projects.graphql.model.Music;
import com.bob.projects.graphql.repository.SingerRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MusicQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private SingerRepository singerRepository;

    public Optional<List<Music>> getSingerMusics(String singerId) {
        return singerRepository
                .findById(singerId)
                .map(Singer::getMusics);
    }
}
