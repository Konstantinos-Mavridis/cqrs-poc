package km.poc.cqrs.projectors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import km.poc.cqrs.repositories.UserReadRepository;
import km.poc.domain.Address;
import km.poc.domain.Contact;
import km.poc.domain.User;
import km.poc.domain.UserAddress;
import km.poc.domain.UserContact;

public class UserProjector {
    UserReadRepository readRepository = new UserReadRepository();

    public UserProjector(final UserReadRepository readRepository) {
        this.readRepository = readRepository;
    }

    public void project(final User user) {
        final UserContact userContact = Optional.ofNullable(readRepository.getUserContact(user.getUserid())).orElse(new UserContact());
        final Map<String, Set<Contact>> contactByType = new HashMap<>();
        for (final Contact contact : user.getContacts()) {
            final Set<Contact> contacts = Optional.ofNullable(contactByType.get(contact.getType())).orElse(new HashSet<>());
            contacts.add(contact);
            contactByType.put(contact.getType(), contacts);
        }
        userContact.setContactByType(contactByType);
        readRepository.addUserContact(user.getUserid(), userContact);

        final UserAddress userAddress = Optional.ofNullable(readRepository.getUserAddress(user.getUserid())).orElse(new UserAddress());
        final Map<String, Set<Address>> addressByRegion = new HashMap<>();
        for (final Address address : user.getAddresses()) {
            final Set<Address> addresses = Optional.ofNullable(addressByRegion.get(address.getState())).orElse(new HashSet<>());
            addresses.add(address);
            addressByRegion.put(address.getState(), addresses);
        }
        userAddress.setAddressByRegion(addressByRegion);
        readRepository.addUserAddress(user.getUserid(), userAddress);
    }
}
