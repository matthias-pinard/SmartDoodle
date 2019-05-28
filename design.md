
# Architecture
### API Rest
Notre API Rest est construite autour de [Quarkus](https://quarkus.io/).
Nous avons utilisé quelques outils délivrés par ce framework tel que Panache. Nous utilisons Hibernate pour la persistence des données. Nous nous somme enfin servi du framework pour dockeriser l'API.
### Base de données
La base de données est une base [postgres](https://hub.docker.com/_/postgres) que nous avons déployer avec docker sur une VM de l'ISTIC.

##### Modèle de donnée :
![SmartDoodle data model](https://github.com/Nassafy/SmartDoodle/blob/master/diag.png?raw=true)
### Front
L'interface utilisateur a été construite avec [Vue.js](https://vuejs.org/).

