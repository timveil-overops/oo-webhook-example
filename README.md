# OverOps WebHook Examples

For a detailed explanation of the OverOps WebHook functionality please visit https://doc.overops.com/docs/outgoing-webhook

This project provides an few WebHook examples using SpringBoot.  This same functionality could be implemented in a variety of frameworks or tools but I prefer SpringBoot.

## Getting Started

To get started simply run the following command or use your IDE of choice.

```bash
./mvnw spring-boot:run
``` 

By default, this will start up the provided examples running on an embedded tomcat instance listening on port `8090`.  This can be easily changed by modifying `application.properties`, etc.

To begin receiving events, enable "Webhook" alerts on any OverOps view.  You should provide one of the following URL's to OverOps.

```
http://<your host name or ip>:8090/wh/simple
http://<your host name or ip>:8090/wh/pivotal-tracker
```

Keep in mind, these need to be accessible from the OverOps server (SaaS or On-prem).  You can also visit my Docker Demos repo for an complete on-prem example: https://github.com/timveil/docker-demos/tree/master/onprem/webhook-example

## Customizing

To create your own WebHook integrations, feel free to fork this repo.  Most of the heavy lifting has been done for you (binding of OverOps data to Java), simply add your logic to one of the [`Controller`](src/main/java/com/overops/webhook/example/web/Controller.java) methods or otherwise rename and refactor

```java
@PostMapping(value = "/wh/custom", consumes = MediaType.APPLICATION_JSON_VALUE)
public void myCustomWebhookHandler(@RequestBody Event event) {

    if (event.getType().equals(Event.Type.TEST)) {
        return;
    }

    // add your custom logic here to do something with the Event...
} 
```

## Pivotal Tracker

One of the examples i've included is a very simple Pivotal Tracker integration which automatically create's `bugs` when the WebHook url is called.  Obviously this could be significantly improved by leveraging additional Tracker fields or providing more OverOps data directly in the ticket.  This example along with others is really designed to show __the art of the possible__ for integrations that are not yet "out of the box".  To use this example just update the following properties in `application.properties`.


```properties
webhook.pivotal.api.url=https://www.pivotaltracker.com
webhook.pivotal.api.project.id=
webhook.pivotal.api.token=
```

## Docker

I created a Docker image if that's your thing.


### Building the Image
```bash
docker build --no-cache -t timveil/oo-webhook-example:latest .
```

### Publishing the Image
```bash
docker push timveil/oo-webhook-example:latest
```

### Running the Image
```bash
docker run -it timveil/oo-webhook-example:latest
```