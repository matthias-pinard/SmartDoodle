# SmartDoodle
Inspiré de [doodle](https://doodle.com/fr/). Une application de sondage pour organiser des réunions en toute simplicité. 
 - Créez une réunion et partagez le lien au invités
 - Fixez plusieurs créneaux si besoin
 - Laissez les invités répondre au sondage
 - Fixez le créneau le plus adapté. Vous savez qui sera présent/absent. Un pad est créé et pré-rempli, ainsi qu'un chat [tlk.io](https://tlk.io/)
 - Chaque utilisateur peut renseigner des informations supplémentaires le concernant

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
