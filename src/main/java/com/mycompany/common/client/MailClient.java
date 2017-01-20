package com.mycompany.common.client;

import com.mycompany.common.client.fallback.MailClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by antongusev on 13.11.16.
 */
@FeignClient(value = "mailservice", fallback = MailClientFallback.class)
public interface MailClient {

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    void send(@RequestParam("email") String email,
                @RequestParam("messageText") String messageText);

}
