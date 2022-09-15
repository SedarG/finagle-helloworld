# scratch
## finagle-helloworld
### Build instructions

* The example can be run through `docker-compose` with the following command
```bash
docker-compose -f docker/docker-compose.yml run finagle-client
```
* The kubernetes manifests are created through kustomize by converting the docker-compose file
```bash
cd docker
kompose convert
mv *.yaml ../kubernetes
```
