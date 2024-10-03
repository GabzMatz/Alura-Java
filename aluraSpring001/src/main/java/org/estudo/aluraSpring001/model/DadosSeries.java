package org.estudo.aluraSpring001.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSeries(
        @JsonAlias("Title") String titulo,
        @JsonProperty("totalSeasons") Integer totalTemporadas,
        @JsonAlias("imdbRating") String avaliacao) {


}
