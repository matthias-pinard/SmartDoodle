# SmartDoodle

## Docker BDD
sudo docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 \--name postgres \
    -e POSTGRES_USER=sarah -e POSTGRES_PASSWORD=connor -e POSTGRES_DB=mydatabase \
    -p 5432:5432 postgres:10.5
    
# Lancer l'api rest
mvn compile quarkus:dev
