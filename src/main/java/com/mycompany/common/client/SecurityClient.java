package com.mycompany.common.client;

import com.mycompany.common.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by antongusev on 26.11.16.
 */
@FeignClient("securityservice")
public interface SecurityClient {

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    DeferredResult<ResponseEntity> register(@RequestBody User userRequest);

    @RequestMapping("/confirm/{username}/{activationKey}")
    DeferredResult<ResponseEntity> confirm(@PathVariable String username, @PathVariable String activationKey);

    @RequestMapping
    ResponseEntity oauth();
}
