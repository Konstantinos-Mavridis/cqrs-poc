package km.poc.cqrs;

import static org.junit.Assert.assertEquals;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import km.poc.cqrs.aggregates.UserAggregate;
import km.poc.cqrs.commands.CreateUserCommand;
import km.poc.cqrs.commands.UpdateUserCommand;
import km.poc.cqrs.projections.UserProjection;
import km.poc.cqrs.projectors.UserProjector;
import km.poc.cqrs.queries.AddressByRegionQuery;
import km.poc.cqrs.queries.ContactByTypeQuery;
import km.poc.cqrs.repositories.UserReadRepository;
import km.poc.cqrs.repositories.UserWriteRepository;
import km.poc.domain.Address;
import km.poc.domain.Contact;
import km.poc.domain.User;

public class UnitTest {
    private UserWriteRepository writeRepository;
    private UserReadRepository readRepository;
    private UserProjector projector;
    private UserAggregate userAggregate;
    private UserProjection userProjection;

    @Before
    public void setUp() {
        writeRepository = new UserWriteRepository();
        readRepository = new UserReadRepository();
        projector = new UserProjector(readRepository);
        userAggregate = new UserAggregate(writeRepository);
        userProjection = new UserProjection(readRepository);
    }

    @Test
    public void givenCQRSApplication_whenCommandRun_thenQueryShouldReturnResult() throws Exception {
        final String userId = UUID.randomUUID().toString();
        User user;
        final CreateUserCommand createUserCommand = new CreateUserCommand(userId, "Tom", "Sawyer");
        user = userAggregate.handleCreateUserCommand(createUserCommand);
        projector.project(user);

        UpdateUserCommand updateUserCommand = new UpdateUserCommand(user.getUserid(),
                Stream.of(new Address("New York", "NY", "10001"), new Address("Los Angeles", "CA", "90001")).collect(Collectors.toSet()),
                Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com"), new Contact("EMAIL", "tom.sawyer@rediff.com")).collect(Collectors.toSet()));
        user = userAggregate.handleUpdateUserCommand(updateUserCommand);
        projector.project(user);

        updateUserCommand = new UpdateUserCommand(userId,
                Stream.of(new Address("New York", "NY", "10001"), new Address("Housten", "TX", "77001")).collect(Collectors.toSet()),
                Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com"), new Contact("PHONE", "700-000-0001")).collect(Collectors.toSet()));
        user = userAggregate.handleUpdateUserCommand(updateUserCommand);
        projector.project(user);

        final ContactByTypeQuery contactByTypeQuery = new ContactByTypeQuery(userId, "EMAIL");
        assertEquals(Stream.of(new Contact("EMAIL", "tom.sawyer@gmail.com")).collect(Collectors.toSet()), userProjection.handle(contactByTypeQuery));
        final AddressByRegionQuery addressByRegionQuery = new AddressByRegionQuery(userId, "NY");
        assertEquals(Stream.of(new Address("New York", "NY", "10001")).collect(Collectors.toSet()), userProjection.handle(addressByRegionQuery));
    }
}
