package km.poc.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class UserContact {
    private Map<String, Set<Contact>> contactByType = new HashMap<>();

    public Map<String, Set<Contact>> getContactByType() {
        return contactByType;
    }

    public void setContactByType(final Map<String, Set<Contact>> contactByType) {
        this.contactByType = contactByType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactByType);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserContact)) {
            return false;
        }
        final UserContact other = (UserContact) obj;
        return Objects.equals(contactByType, other.contactByType);
    }

    @Override
    public java.lang.String toString() {
        return "UserContact(contactByType=" + getContactByType() + ")";
    }
}
