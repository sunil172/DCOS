package com.dcos.configuration;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcos.model.Users;
import com.dcos.validation.EmailExistsException;

@Service
@Transactional
class UsersService implements IUserService {

    @Autowired
    private UsersRepository userRepository;

    @Override
    public Users registerNewUser(final Users user) throws EmailExistsException {
        if (emailExist(user.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + user.getEmail());
        }
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        final Users user = userRepository.findByEmail(email);
        return user != null;
    }

}
