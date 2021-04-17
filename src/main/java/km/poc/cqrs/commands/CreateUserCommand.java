package km.poc.cqrs.commands;

import java.util.Objects;

public class CreateUserCommand {
    private String userId;
    private String firstName;
    private String lastName;

    public CreateUserCommand(final String userId, final String firstName, final String lastName) {
        super();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userId);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateUserCommand)) {
            return false;
        }
        final CreateUserCommand other = (CreateUserCommand) obj;
        return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName) && Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "CreateUserCommand(userId=" + getUserId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ")";
    }
}
