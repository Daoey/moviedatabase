package se.joas.moviedatabase.model;

public final class ReviewUser {

    private final int id;
    private final String username;
    private final String registerDate;

    private ReviewUser(int id, String username, String registerDate) {
        this.id = id;
        this.username = username;
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Review user id: " + id + "\nUsername: " + username + "\nRegister date: " + registerDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReviewUser) {
            ReviewUser otherReviewUser = (ReviewUser) obj;
            return id == otherReviewUser.id && username.equals(otherReviewUser.username)
                    && registerDate.equals(otherReviewUser.registerDate);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result += 31 * id;
        result += 31 * username.hashCode();
        result += 31 * registerDate.hashCode();
        return result;
    }

    public static ReviewUserBuilder builder(String username, String registerDate) {
        return new ReviewUserBuilder(username, registerDate);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public static class ReviewUserBuilder {

        private int id = 0;
        private String username;
        private String registerDate;

        private ReviewUserBuilder(String username, String registerDate) {
            this.username = username;
            this.registerDate = registerDate;
        }

        public ReviewUser build() {
            return new ReviewUser(id, username, registerDate);
        }

        public ReviewUserBuilder setId(int id) {
            this.id = id;
            return this;
        }

    }
}
