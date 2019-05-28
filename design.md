
# Architecture
### API Rest
Notre API Rest est construite autour de [Quarkus](https://quarkus.io/).
Nous avons utilisé quelques outils délivrés par ce framework tel que Panache. Nous utilisons Hibernate pour la persistence des données. Nous nous somme enfin servi du framework pour dockeriser l'API.
### Base de données
La base de données est une base [postgres](https://hub.docker.com/_/postgres) que nous avons déployer avec docker sur une VM de l'ISTIC.

##### Modèle de donnée :
![SmartDoodle data model](https://github.com/Nassafy/SmartDoodle/blob/master/diag.png?raw=true)

 - Un sondage de réunion possède une liste de dates possibles ainsi qu'une liste d'invités. 
 - Chaque invité peut choisir les dates qui lui conviennent. 
 - Un invité peut ne pas avoir de compte ou bien etre lié à un compte utilisateur.
### Front
L'interface utilisateur a été construite avec [Vue.js](https://vuejs.org/).

