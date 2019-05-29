# API
Pour installer l'API sur une machine, il suffit de récuperer le fichier [docker-compose.yml](https://github.com/Nassafy/SmartDoodle/blob/master/docker/docker-compose.yml) du projet et d'éxecuter la commande :  
`docker-compose up`

L'API sera alors disponible sur le port 80, et le pad sur le port 3500.

# Site WEB
Le site web requête l'API qui doit etre mise en place au préalable
Pour le déployer sur localhost:8080, récuperez le dossier **smart_doodle_front** et dans le dossier **doodle_front**, exécutez :  
 - `npm i`  
 - `npm start`  
