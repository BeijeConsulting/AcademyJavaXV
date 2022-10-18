package it.beije.musicstore.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistaRequestDto {
    @JsonProperty(value = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
