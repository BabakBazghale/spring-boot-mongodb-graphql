package com.bob.projects.graphql.resolver;

import com.bob.projects.graphql.exception.SingerNotExistException;
import com.bob.projects.graphql.model.Music;
import com.bob.projects.graphql.model.Singer;
import com.bob.projects.graphql.repository.SingerRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MusicMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private SingerRepository singerRepository;

    public Singer appendMusic(String singerId, String genre, String chord, String instrument) {
        return singerRepository.findById(singerId)
                .map(singer -> appendMusic(singer, genre, chord, instrument))
                .orElseThrow(() -> new SingerNotExistException("Singer not found."));
    }

    private Singer appendMusic(Singer singer, String genre, String chord, String instrument) {
        Optional.ofNullable(singer.getMusics())
                .ifPresentOrElse(music ->
                        music.add(Music.builder()
                                .genre(genre)
                                .chord(chord)
                                .instrument(instrument)
                                .build()), () ->
                        singer.setMusics(List.of(Music.builder()
                                .genre(genre)
                                .chord(chord)
                                .instrument(instrument)
                                .build())));
        return singerRepository.save(singer);
    }

}
