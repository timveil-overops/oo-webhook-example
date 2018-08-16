http://host.docker.internal:8090/webhook



### Building the Image
```bash
docker build --no-cache -t timveil/oo-webhook-example:alpine .
```

### Publishing the Image
```bash
docker push timveil/oo-webhook-example:alpine
```

### Running the Image
```bash
docker run -it timveil/oo-webhook-example:alpine
```