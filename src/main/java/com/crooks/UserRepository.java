/*
 * Copyright (c) 2016.
 */

package com.crooks;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by johncrooks on 6/21/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
     User findByUsername(String username);
}
