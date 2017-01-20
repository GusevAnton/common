package com.mycompany.common.client.fallback;

import com.mycompany.common.client.MailClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by antongusev on 19.11.16.
 */
@Component
public class MailClientFallback implements MailClient {
    @Override
    public void send(@RequestParam("email") String email, @RequestParam("messageText") String messageText) {

    }
}
