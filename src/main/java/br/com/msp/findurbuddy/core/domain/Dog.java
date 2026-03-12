package br.com.msp.findurbuddy.core.domain;

import java.net.URL;

public record Dog(
        String id,
        String name,
        String breed,
        String age,
        String gender,
        String details,
        URL photoUrl
) {
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private String breed;
        private String age;
        private String gender;
        private String details;
        private URL photoUrl;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder breed(String breed) {
            this.breed = breed;
            return this;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }
        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder photoUrl(URL photoUrl) {
            this.photoUrl = photoUrl;
            return this;
        }

        public Dog build() {
            return new Dog(id, name, breed, age, gender, details, photoUrl);
        }
    }
}
