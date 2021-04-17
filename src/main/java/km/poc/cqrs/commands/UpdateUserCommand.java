package km.poc.cqrs.commands;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import km.poc.domain.Address;
import km.poc.domain.Contact;

public class UpdateUserCommand {
    private String userId;
    private Set<Address> addresses = new HashSet<>();
    private Set<Contact> contacts = new HashSet<>();

    public UpdateUserCommand(final String userId, final Set<Address> addresses, final Set<Contact> contacts) {
        super();
        this.userId = userId;
        this.addresses = addresses;
        this.contacts = contacts;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(final Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(final Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses, contacts, userId);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateUserCommand)) {
            return false;
        }
        final UpdateUserCommand other = (UpdateUserCommand) obj;
        return Objects.equals(addresses, other.addresses) && Objects.equals(contacts, other.contacts) && Objects.equals(userId, other.userId);
    }

    @Override
    public String toString() {
        return "UpdateUserCommand(userId=" + getUserId() + ", addresses=" + getAddresses() + ", contacts=" + getContacts() + ")";
    }
}
