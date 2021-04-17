package km.poc.cqrs.aggregates;

import km.poc.cqrs.commands.CreateUserCommand;
import km.poc.cqrs.commands.UpdateUserCommand;
import km.poc.cqrs.repositories.UserWriteRepository;
import km.poc.domain.User;

public class UserAggregate {

    private final UserWriteRepository writeRepository;

    public UserAggregate(final UserWriteRepository repository) {
        writeRepository = repository;
    }

    public User handleCreateUserCommand(final CreateUserCommand command) {
        final User user = new User(command.getUserId(), command.getFirstName(), command.getLastName());
        writeRepository.addUser(user.getUserid(), user);
        return user;
    }

    public User handleUpdateUserCommand(final UpdateUserCommand command) {
        final User user = writeRepository.getUser(command.getUserId());
        user.setAddresses(command.getAddresses());
        user.setContacts(command.getContacts());
        writeRepository.addUser(user.getUserid(), user);
        return user;
    }
}
