package com.mycompany.common.client;

import com.mycompany.common.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by antongusev on 16.11.16.
 */
@FeignClient("databaseservice")
public interface UserDatabaseClient {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    Resources<User> getUserList();

    @RequestMapping(value = "/user/search/getByUsername", method = RequestMethod.GET)
    Resource<User> findUserByUsername(@RequestParam("username") String username);

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    Resource<User> saveUser(User user);

}
