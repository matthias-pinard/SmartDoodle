# SmartDoodle
Inspiré de [doodle](https://doodle.com/fr/). Une application de sondage pour organiser des réunions en toute simplicité. Fixez plusieurs créneaux, laissez les invités répondre au sondage et fixez le créneau le plus adapté.

Le but de ce projet est de mettre en place une application rest avec les outils avancés du développement industriel.
Nous avons choisi Quarkus, un framework très récent qui simplifie un certain nombre d'étapes du développement. Il a également la faculté d'être facilement et rapidement déployable avec docker.

## Docker BDD
```console
sudo docker run --ulimit memlock=-1:-1 -it --rm=true --memory-swappiness=0 \--name postgres \
    -e POSTGRES_USER=sarah -e POSTGRES_PASSWORD=connor -e POSTGRES_DB=mydatabase \
    -p 5432:5432 postgres:10.5 
```
    
# Lancer l'api rest
```console
mvn compile quarkus:dev
```
