package km.poc.domain;

import java.util.Objects;

public class Address {
    private String city;
    private String state;
    private String postcode;

    public Address(final String city, final String state, final String postcode) {
        super();
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, postcode, state);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        final Address other = (Address) obj;
        return Objects.equals(city, other.city) && Objects.equals(postcode, other.postcode) && Objects.equals(state, other.state);
    }

    @Override
    public String toString() {
        return "Address(city=" + getCity() + ", state=" + getState() + ", postcode=" + getPostcode() + ")";
    }
}
