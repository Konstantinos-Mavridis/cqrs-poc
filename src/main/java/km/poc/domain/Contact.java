package km.poc.domain;

import java.util.Objects;

public class Contact {
    private String type;
    private String detail;

    public Contact(final String type, final String detail) {
        super();
        this.type = type;
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(final String detail) {
        this.detail = detail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(detail, type);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        final Contact other = (Contact) obj;
        return Objects.equals(detail, other.detail) && Objects.equals(type, other.type);
    }

    @Override
    public String toString() {
        return "Contact(type=" + getType() + ", detail=" + getDetail() + ")";
    }
}
