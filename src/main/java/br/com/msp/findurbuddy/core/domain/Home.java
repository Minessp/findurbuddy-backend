package br.com.msp.findurbuddy.core.domain;

public record Home (
        String id,
        String name,
        String description,
        String address,
        String city,
        String state,
        String phone
){
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String name;
        private String description;
        private String address;
        private String city;
        private String state;
        private String phone;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder state(String state) {
            this.state = state;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Home build() {
            return new Home(id, name, description, address, city, state, phone);
        }
    }
}
