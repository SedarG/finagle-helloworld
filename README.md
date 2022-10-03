# finagle-helloworld
## finagle-helloworld
### Build instructions

* The example can be run through `docker-compose` with the following command
```bash
docker-compose -f docker/docker-compose.yml run finagle-client
```
* The kubernetes manifests are created through kustomize by converting the docker-compose file. This will remove the `px-finagle` namespace, which must be updated manually.
```bash
cd kubernetes
kompose convert -f ../docker/docker-compose.yml
```
