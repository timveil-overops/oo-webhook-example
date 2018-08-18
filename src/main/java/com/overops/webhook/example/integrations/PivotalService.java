package com.overops.webhook.example.integrations;

import com.overops.webhook.example.data.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class PivotalService extends TemplateService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public PivotalService(SpringTemplateEngine templateEngine) {
        super(templateEngine);
    }

    @Value("${webhook.pivotal.api.project.id}")
    private String trackerProjectId;

    @Value("${webhook.pivotal.api.token}")
    private String trackerToken;

    @Value("${webhook.pivotal.api.url}")
    private String trackerUrl;


    public String getStoryUrl() {
        return trackerUrl + "/services/v5/projects/" + trackerProjectId + "/stories";
    }


    private PivotalStory convertEventToStory(Event event) {

        // pivotal supports markdown for text fields: https://www.pivotaltracker.com/help/articles/formatting_your_text_with_markdown/
        PivotalStory story = new PivotalStory();
        story.setStoryType("bug");
        story.setName(getName(event));
        story.setDescription(getDescription(event));

        return story;
    }


    public HttpEntity<PivotalStory> getPivotalStory(Event event) {

        // create story from OverOps event: https://www.pivotaltracker.com/help/api/rest/v5#projects_project_id_stories_post
        PivotalStory story = convertEventToStory(event);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-TrackerToken", trackerToken);

        return new HttpEntity<>(story, headers);

    }
}
