package km.poc.cqrs.queries;

import java.util.Objects;

public class AddressByRegionQuery {
    private String userId;
    private String state;

    public AddressByRegionQuery(final String userId, final String state) {
        super();
        this.userId = userId;
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, userId);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressByRegionQuery)) {
            return false;
        }
        final AddressByRegionQuery other = (AddressByRegionQuery) obj;
        return Objects.equals(state, other.state) && Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "AddressByRegionQuery(userId=" + getUserId() + ", state=" + getState() + ")";
    }
}
