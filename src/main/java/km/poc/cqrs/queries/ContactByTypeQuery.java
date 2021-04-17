package km.poc.cqrs.queries;

import java.util.Objects;

public class ContactByTypeQuery {
    private String userId;
    private String contactType;

    public ContactByTypeQuery(final String userId, final String contactType) {
        super();
        this.userId = userId;
        this.contactType = contactType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(final String contactType) {
        this.contactType = contactType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactType, userId);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactByTypeQuery)) {
            return false;
        }
        final ContactByTypeQuery other = (ContactByTypeQuery) obj;
        return Objects.equals(contactType, other.contactType) && Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "ContactByTypeQuery(userId=" + getUserId() + ", contactType=" + getContactType() + ")";
    }
}
