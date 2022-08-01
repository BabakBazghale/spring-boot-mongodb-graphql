package com.bob.projects.graphql.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Music {
    @Id
    private String id;
    private String genre;
    private String chord;
    private String instrument;
}
