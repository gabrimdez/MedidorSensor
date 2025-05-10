package com.cebem.medidor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Superhero {

    private String id;
    private String name;

    @JsonProperty("powerstats")
    private PowerStats powerStats;

    @JsonProperty("biography")
    private Biography biography;

    @JsonProperty("appearance")
    private Appearance appearance;

    @JsonProperty("work")
    private Work work;

    @JsonProperty("connections")
    private Connections connections;

    @JsonProperty("image")
    private Image image;

    @Data
    public static class PowerStats {
        private String intelligence;
        private String strength;
        private String speed;
        private String durability;
        private String power;
        private String combat;
    }

    @Data
    public static class Biography {
        @JsonProperty("full-name")
        private String fullName;

        @JsonProperty("alter-egos")
        private String alterEgos;

        private String[] aliases;

        @JsonProperty("place-of-birth")
        private String placeOfBirth;

        @JsonProperty("first-appearance")
        private String firstAppearance;

        private String publisher;
        private String alignment;
    }

    @Data
    public static class Appearance {
        private String gender;
        private String race;
        private String[] height;
        private String[] weight;

        @JsonProperty("eye-color")
        private String eyeColor;

        @JsonProperty("hair-color")
        private String hairColor;
    }

    @Data
    public static class Work {
        private String occupation;
        private String base;
    }

    @Data
    public static class Connections {
        private String groupAffiliation;
        private String relatives;
    }

    @Data
    public static class Image {
        private String url;
    }
}
