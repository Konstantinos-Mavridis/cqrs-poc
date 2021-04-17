package km.poc.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class UserAddress {
    private Map<String, Set<Address>> addressByRegion = new HashMap<>();

    public Map<String, Set<Address>> getAddressByRegion() {
        return addressByRegion;
    }

    public void setAddressByRegion(final Map<String, Set<Address>> addressByRegion) {
        this.addressByRegion = addressByRegion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressByRegion);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAddress)) {
            return false;
        }
        final UserAddress other = (UserAddress) obj;
        return Objects.equals(addressByRegion, other.addressByRegion);
    }

    @Override
    public String toString() {
        return "UserAddress(addressByRegion=" + getAddressByRegion() + ")";
    }
}
