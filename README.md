# scratch
## finagle-helloworld
### Build instructions
* Build on sbt shell. 
* Required step to publish images to minikube docker registry: execute `eval $(minikube -p minikube docker-env)` on the shell you'll be issuing sbt commands
* cd to `finagle-helloworld` and run sbt on a command line
* inside the sbt shell, `client/Docker/publishLocal` will publish the finagle-helloworld-client to the local docker registry. likewise, `server/Docker/publishLocal` will do the same for server image

### Setup instructions
* `kubectl create deployment hello-finagle-server --image=hellofinagleserver:0.0.2`
* `kubectl expose deployment hello-finagle-server --type=NodePort --port=9992`
* `kubectl create deployment hello-finagle-client --image=hellofinagleclient:0.0.2`
* `kubectl expose deployment hello-finagle-client --type=NodePort --port=9992`
