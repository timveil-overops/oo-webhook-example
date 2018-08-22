package com.overops.webhook.example.integrations;

import com.overops.webhook.example.data.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

public abstract class TemplateService<T> {


    SpringTemplateEngine templateEngine;

    @Autowired
    public TemplateService(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public abstract ResponseEntity<T> createEntity(Event event);

    String getName(Event event) {

        Context context = new Context();
        context.setVariable("event", event);

        String name = null;

        switch (event.getData().getType()) {

            case NEW_EVENT:
                name = templateEngine.process("new-event-name", context);
                break;
            case RESURFACED:
                name = templateEngine.process("resurfaced-name", context);
                break;
            case THRESHOLD:
                name = templateEngine.process("threshold-name", context);
                break;
        }

        return name;

    }

    String getMessage(Event event) {
        Context context = new Context();
        context.setVariable("event", event);

        String message = null;

        switch (event.getData().getType()) {

            case NEW_EVENT:
                message = templateEngine.process("new-event-message", context);
                break;
            case RESURFACED:
                message = templateEngine.process("resurfaced-message", context);
                break;
            case THRESHOLD:
                message = templateEngine.process("threshold-message", context);
                break;
        }

        return message;
    }

    String getDescription(Event event) {
        Context context = new Context();
        context.setVariable("event", event);

        String description = null;

        switch (event.getData().getType()) {

            case NEW_EVENT:
                description = templateEngine.process("new-event-description", context);
                break;
            case RESURFACED:
                description = templateEngine.process("resurfaced-description", context);
                break;
            case THRESHOLD:
                description = templateEngine.process("threshold-description", context);
                break;
        }

        return description;
    }
}
