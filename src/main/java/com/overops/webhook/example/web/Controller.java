package com.overops.webhook.example.web;

import com.overops.webhook.example.data.Event;
import com.overops.webhook.example.integrations.PivotalStory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private Environment environment;


    @PostMapping(value = "/simple", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void simple(@RequestBody Event event) {

        if (event.getType().equals(Event.Type.TEST)) {
            log.debug("this is just a test");

            return;
        }

        log.debug("OverOps event posted to /simple via Webhook integration: {}", event.toString());

        // add your custom logic here to do something with the Event...
    }

    @PostMapping(value = "/pivotal-tracker", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void pivotalTracker(@RequestBody Event event) {

        if (event.getType().equals(Event.Type.TEST)) {
            log.debug("this is just a test");

            return;
        }

        log.debug("OverOps event posted to /pivotal-tracker via Webhook integration: {}", event.toString());

        // create story from OverOps event: https://www.pivotaltracker.com/help/api/rest/v5#projects_project_id_stories_post
        PivotalStory story = getPivotalStory(event);

        // get pivotal tracker api details from application.properties
        String trackerProjectId = environment.getProperty("webhook.pivotal.api.project.id");
        String trackerToken = environment.getProperty("webhook.pivotal.api.token");
        String trackerUrl = environment.getProperty("webhook.pivotal.api.url") + "/services/v5/projects/" + trackerProjectId + "/stories";

        // create RestTemplate and POST story
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-TrackerToken", trackerToken);

        HttpEntity<PivotalStory> httpEntity = new HttpEntity<>(story, headers);

        restTemplate.postForObject(trackerUrl, httpEntity, PivotalStory.class);

    }

    private PivotalStory getPivotalStory(Event event) {

        PivotalStory story = new PivotalStory();
        story.setStoryType("bug");
        story.setName(event.getData().getSummary());
        story.setDescription("for additional details please see OverOps Automated Root Cause Analysis (ARC) here: " + event.getData().getPayload().getLink());

        return story;
    }


}
