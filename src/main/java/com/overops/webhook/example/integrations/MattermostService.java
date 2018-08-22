package com.overops.webhook.example.integrations;

import com.overops.webhook.example.data.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class MattermostService extends TemplateService<String> {

    @Value("${webhook.mattermost.channel}")
    private String channel;

    @Value("${webhook.mattermost.username}")
    private String username;

    @Value("${webhook.mattermost.url}")
    private String url;



    public MattermostService(SpringTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Override
    public ResponseEntity<String> createEntity(Event event) {

        MattermostMessage message = new MattermostMessage();
        message.setChannel(channel);
        message.setUsername(username);
        message.setText(getMessage(event));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MattermostMessage> entity = new HttpEntity<>(message, headers);

        RestTemplate restTemplate = new RestTemplateBuilder().build();

        return restTemplate.postForEntity(url, entity, String.class, (Object) null);

    }
}
