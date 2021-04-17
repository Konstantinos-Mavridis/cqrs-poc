package km.poc.cqrs.repositories;

import java.util.HashMap;
import java.util.Map;

import km.poc.domain.User;

public class UserWriteRepository {
    private final Map<String, User> store = new HashMap<>();

    public void addUser(final String id, final User user) {
        store.put(id, user);
    }

    public User getUser(final String id) {
        return store.get(id);
    }
}
