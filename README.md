## Sample Azure AKS App

### Modules
- Spring Boot
- Docker
- Azure Kubernetes
- Azure PostgreSQL

### Development

#### Spring Boot
- app build `mvn clean install`
- app run `mvn spring-boot:run`

#### Docker
- docker build `docker build . -t <docker_hub_account>/azure-aks`
- docker run `docker run -p 8080:8080 <docker_hub_account>/azure-aks`
- docker push `docker push <docker_hub_account>/azure-aks`

#### Azure
- azure login `az login`
- azure create resource group `az group create --name aks-resource-group --location germanywestcentral`
- azure create aks cluster `az aks create --resource-group aks-resource-group --name aks-cluster --node-count 2`
- azure create postgres `az postgres server create --name aks-server --resource-group aks-resource-group --location germanywestcentral --admin-user <db_user> --admin-password <db_password> --sku-name B_Gen5_1`
- azure delete all resources `az group delete --name aks-resource-group --yes --no-wait`

#### Kubernetes

![Kubernetes Architecture](https://platform9.com/wp-content/uploads/2019/05/kubernetes-constructs-concepts-architecture.jpg)

- [Namespaces](https://kubernetes.io/docs/concepts/overview/working-with-objects/namespaces/) - In Kubernetes, namespaces provides a mechanism for isolating groups of resources within a single cluster.
- [Pod](https://kubernetes.io/docs/concepts/workloads/pods/) - Pods are the smallest deployable units of computing that you can create and manage in Kubernetes.
- [Deployments](https://kubernetes.io/docs/concepts/workloads/controllers/deployment/) - A Deployment provides declarative updates for Pods and ReplicaSets.
- [StatefulSets](https://kubernetes.io/docs/concepts/workloads/controllers/statefulset/) - StatefulSet is the workload API object used to manage stateful applications.
- [ReplicaSet](https://kubernetes.io/docs/concepts/workloads/controllers/replicaset/) - A ReplicaSet's purpose is to maintain a stable set of replica Pods running at any given time.
- [Service](https://kubernetes.io/docs/concepts/services-networking/service/) - Service is a method for exposing a network application that is running as one or more Pods in your cluster.
- [Ingress](https://kubernetes.io/docs/concepts/services-networking/ingress/) - An API object that manages external access to the services in a cluster, typically HTTP.
- [ConfigMaps](https://kubernetes.io/docs/concepts/configuration/configmap/) - A ConfigMap allows you to decouple environment-specific configuration from your container images, so that your applications are easily portable.
- [Secrets](https://kubernetes.io/docs/concepts/configuration/secret/) - A Secret is an object that contains a small amount of sensitive data such as a password, a token, or a key. Such information might otherwise be put in a Pod specification or in a container image. Using a Secret means that you don't need to include confidential data in your application code.

#### Commands ([cheatsheet](https://kubernetes.io/docs/reference/kubectl/cheatsheet/))

- kubectl get credentials `az aks get-credentials --resource-group aks-resource-group --name aks-cluster`
- kubectl create secret `kubectl create secret generic aks-secret --from-literal=db-url=jdbc:postgresql://<db-name>.postgres.database.azure.com:5432/postgres?sslmode=require --from-literal=db-user=<db_user>@<db_name> --from-literal=db-password=<db_password>`
- kubectl create deployment `kubectl create deployment azure-aks-deployment --image=mafitov/azure-aks:latest`
- kubectl create deployment and service using file `kubectl apply -f https://raw.githubusercontent.com/<github_account>/azure-aks/master/aks.yaml`
- kubectl get all components `kubectl get all | grep aks`
- kubectl get nodes `kubectl get nodes`
- kubectl get namespaces `kubectl get namespace`
- kubectl get deployment `kubectl get deployment`
- kubectl get replicaset `kubectl get replicaset`
- kubectl get pods `kubectl get pods`
- kubectl get service `kubectl get service azure-aks --watch`
- kubectl get secret `kubectl get secret`
- kubectl describe pod `kubectl describe pod <pod-name>`
- kubectl describe deployment `kubectl describe deployment <deployment-name>`
- kubectl show logs `kubectl logs <pod-name> --all-containers`
- kubectl open terminal `kubectl exec -it <pod-name> --bin/bash`
- kubectl delete deployment `kubectl delete deployment <deployment-name>`