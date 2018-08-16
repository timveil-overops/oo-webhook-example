package com.overops.webhook.example.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Controller {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    public void post(HttpServletRequest request, HttpServletResponse response) {

        log.debug("calling post");

    }


    @RequestMapping(value = "/webhook", method = RequestMethod.GET)
    public void get() {

        log.debug("calling get");

    }

}
