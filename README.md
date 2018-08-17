#OverOps WebHook Examples

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