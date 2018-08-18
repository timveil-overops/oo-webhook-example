package com.overops.webhook.example.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class DateDeserializer extends JsonDeserializer<DateTime> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public DateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = p.getText().trim();

        try {
            return new DateTime(Long.valueOf(date));
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
