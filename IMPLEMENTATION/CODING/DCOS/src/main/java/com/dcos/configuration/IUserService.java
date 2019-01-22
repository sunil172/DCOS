package com.dcos.configuration;

import com.dcos.model.Users;
import com.dcos.validation.EmailExistsException;

public interface IUserService {

    Users registerNewUser(Users user) throws EmailExistsException;

}
