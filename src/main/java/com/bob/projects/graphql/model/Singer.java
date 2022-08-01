package com.bob.projects.graphql.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document
public class Singer {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String gender;
    @Indexed(unique = true)
    private String thumbnail;
    private List<Music> musics;
}
