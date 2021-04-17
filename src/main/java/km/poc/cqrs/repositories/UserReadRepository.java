package km.poc.cqrs.repositories;

import java.util.HashMap;
import java.util.Map;

import km.poc.domain.UserAddress;
import km.poc.domain.UserContact;

public class UserReadRepository {
    private final Map<String, UserAddress> userAddress = new HashMap<>();
    private final Map<String, UserContact> userContact = new HashMap<>();

    public void addUserAddress(final String id, final UserAddress user) {
        userAddress.put(id, user);
    }

    public UserAddress getUserAddress(final String id) {
        return userAddress.get(id);
    }

    public void addUserContact(final String id, final UserContact user) {
        userContact.put(id, user);
    }

    public UserContact getUserContact(final String id) {
        return userContact.get(id);
    }
}
