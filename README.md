## Sample Azure AKS App

### Modules
- Spring Boot
- Docker
- Azure Kubernetes
- Azure PostgreSQL

### Development
- app build `mvn clean install`
- app run `mvn spring-boot:run`
- docker build `docker build . -t <docker_hub_account>/azure-aks`
- docker run `docker run -p 8080:8080 <docker_hub_account>/azure-aks`
- docker push `docker push <docker_hub_account>/azure-aks`
- azure login `az login`
- azure create resource group `az group create --name aks-resource-group --location germanywestcentral`
- azure create aks cluster `az aks create --resource-group aks-resource-group --name aks-cluster --node-count 2`
- azure create postgres `az postgres server create --name aks-server --resource-group aks-resource-group --location germanywestcentral --admin-user <db_user> --admin-password <db_password> --sku-name B_Gen5_1`
- kubectl get credentials `az aks get-credentials --resource-group aks-resource-group --name aks-cluster`
- kubectl get nodes `kubectl get nodes`
- kubectl create secret `kubectl create secret generic aks-secret --from-literal=db-url=<db_url> --from-literal=db-user=<db_user> --from-literal=db-password=<db_password>`
- kubectl create deployment and service `kubectl apply -f https://raw.githubusercontent.com/<github_account>/azure-aks/master/aks.yaml`
- kubectl get nodes `kubectl get pods`
- kubectl get service `kubectl get service azure-aks --watch`
- kubectl describe pod `kubectl describe pod <pod-name>`
- kubectl show logs `kubectl logs <pod-name> --all-containers`

### Clear resources
- azure delete all resources `az group delete --name aks-resource-group --yes --no-wait`