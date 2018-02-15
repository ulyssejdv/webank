# Welcome to Webank Docs

## Commands

* `mkdocs serve` - Start the live-reloading docs server.
* `mkdocs build` - Build the documentation site.
* `mkdocs help` - Print this help message.


## Docker stack


### Init of data files

1. Start the container whithout mount any volume

`docker run webank/postgres`

2. Copy data files from the container to the host

`docker cp <ID CONTAINER POSTGRES>:/var/lib/postgresql/9.3/main /webank`

### Before running all services in docker you have to build it

`mvn clean install`

*__You can user docker to run maven ;) :__*

`docker run -it --rm --name my-maven-project -v "$PWD":/usr/src/mymaven -w /usr/src/mymaven maven:3.2-jdk-8 mvn clean install`

### Build all images

`docker-compose build`


### Start all services of the webank stack

*__Take care ! You have to init swarn on the host__*

`docker swarn init`

Up the stack

`docker stack deploy -c docker-compose.yml webank-stack`


Wait until all services are fully running and then can access them.


### Stack manipulations

Shutdown all services of the webank stack

`docker stack rm webank-stack`


Connexion to the dockerised database

`psql -h localhost -p 25432 -d webank -U docker --password`

Make a backup of the database (after exec, replace the id by the real container id)

`docker exec d8dc5836d037 usr/lib/postgresql/9.3/bin/pg_dump webank > backup.sql`

Re-import backup (or any sql file) into the docker postgres instance

`psql -h localhost -p 25432 -d webank -U docker --password < backup.sql`