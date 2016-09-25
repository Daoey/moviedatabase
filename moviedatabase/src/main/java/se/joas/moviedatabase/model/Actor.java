package se.joas.moviedatabase.model;

public final class Actor {

    private final int id;
    private final String firstName;
    private final String middleName;
    private final String lastName;

    private Actor(int id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public static ActorBuilder builder(String firstName, String lastName) {
        return new ActorBuilder(firstName, lastName);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class ActorBuilder {

        private int id = 0;
        private String firstName;
        private String middleName = "";
        private String lastName;

        private ActorBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public ActorBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ActorBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Actor build() {
            return new Actor(id, firstName, middleName, lastName);
        }
    }

}
