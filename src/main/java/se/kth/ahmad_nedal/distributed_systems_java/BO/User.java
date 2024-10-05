package se.kth.ahmad_nedal.distributed_systems_java.BO;

/**
 * The User class represents a user in the system with a username and password.
 * It provides methods to access and modify the user's credentials.
 */
public class User {

    /** The username of the user. */
    private String username;

    /** The password of the user. */
    private String password;

    /**
     * Constructs a User object with the specified username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the new username to set for the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the new password to set for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
