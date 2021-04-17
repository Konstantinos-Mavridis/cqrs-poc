package km.poc.cqrs.projections;

import java.util.Set;

import km.poc.cqrs.queries.AddressByRegionQuery;
import km.poc.cqrs.queries.ContactByTypeQuery;
import km.poc.cqrs.repositories.UserReadRepository;
import km.poc.domain.Address;
import km.poc.domain.Contact;
import km.poc.domain.UserAddress;
import km.poc.domain.UserContact;

public class UserProjection {
    private final UserReadRepository repository;

    public UserProjection(final UserReadRepository repository) {
        this.repository = repository;
    }

    public Set<Contact> handle(final ContactByTypeQuery query) throws Exception {
        final UserContact userContact = repository.getUserContact(query.getUserId());
        if (userContact == null) {
            throw new Exception("User does not exist.");
        }
        return userContact.getContactByType().get(query.getContactType());
    }

    public Set<Address> handle(final AddressByRegionQuery query) throws Exception {
        final UserAddress userAddress = repository.getUserAddress(query.getUserId());
        if (userAddress == null) {
            throw new Exception("User does not exist.");
        }
        return userAddress.getAddressByRegion().get(query.getState());
    }
}
