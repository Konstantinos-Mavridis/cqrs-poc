package km.poc.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private String userid;
    private String firstname;
    private String lastname;
    private Set<Contact> contacts = new HashSet<>();
    private Set<Address> addresses = new HashSet<>();

    public User(final String userid, final String firstname, final String lastname) {
        super();
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(final String userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(final String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(final Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(final Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses, contacts, firstname, lastname, userid);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(addresses, other.addresses) && Objects.equals(contacts, other.contacts) && Objects.equals(firstname, other.firstname)
                && Objects.equals(lastname, other.lastname) && Objects.equals(userid, other.userid);
    }

    @Override
    public String toString() {
        return "User(userid=" + getUserid() + ", firstname=" + getFirstname() + ", lastname=" + getLastname() + ", contacts=" + getContacts() + ", addresses="
                + getAddresses() + ")";
    }
}
