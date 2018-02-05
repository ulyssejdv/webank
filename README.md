# Backend Webank

Projet modulaire maven !

Certains des modules présent exposent des interfaces REST qui se lancent avec la commande suivante :

`mvn spring-boot:run`

D'autres modules sont des utilitaires pour porte des classes communes à différents modules

### Si vous créez de nouveaux modules, il faut les ajouter dans le POM parent




Externalisation des parametre spring

`SPRING_APPLICATION_JSON='{"spring": {"datasource": {"url": "jdbc:postgresql://localhost:5432/webank"}}}' java -jar target/data-access-service-1.0.0.jar`



java -jar target/data-access-service-1.0.0.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/webank



# How to setup the webank HDFS cluster

## Hosts

On each host, run the following commands :

`sudo apt-get update`

### Configure DNS

edit `/etc/hosts` on each host to know each other

test pingin the hostname

### Install JAVA

`sudo apt-get install default-jdk`

make sur java is well installed

`java -version`


### Install Hadoop

download the binary (2.8.2 in our case)

`wget http://apache.mindstudios.com/hadoop/common/hadoop-2.8.2/hadoop-2.8.2.tar.gz`

`tar -xzvf hadoop-2.8.2.tar.gz`

`sudo mv hadoop-2.8.2 /usr/local/hadoop`


change this line in : `/usr/local/hadoop/etc/hadoop/hadoop-env.sh`

with the following

```
#export JAVA_HOME=${JAVA_HOME}
export JAVA_HOME=$(readlink -f /usr/bin/java | sed "s:bin/java::")
```

make sure hadoop is well installed

`/usr/local/hadoop/bin/hadoop`

## Install Ambari

On the master host (ambari-server) :

`ssh-keygen`

`ssh-keygen`
copy the .ssh/id_rsa.pub on each slave

`scp .ssh/id_rsa.pub user@10.168.1.16:/home/user/.ssh/`

`scp .ssh/id_rsa.pub user@10.168.1.17:/home/user/.ssh/`

Check ssh access work well

`ssh user@10.168.1.16`
`ssh user@10.168.1.17`


install ambari server on the master

`wget -O /etc/apt/sources.list.d/ambari.list http://public-repo-1.hortonworks.com/ambari/ubuntu16/2.x/updates/2.6.0.0/ambari.list`

`apt-key adv --recv-keys --keyserver keyserver.ubuntu.com B9733A7A07513CAD`

`apt-get update`

`apt-get install ambari-server`

`ambari-server setup`

go to the Ambari admin web interface

References :

- [https://www.digitalocean.com/community/tutorials/how-to-install-hadoop-in-stand-alone-mode-on-ubuntu-16-04](https://www.digitalocean.com/community/tutorials/how-to-install-hadoop-in-stand-alone-mode-on-ubuntu-16-04)
- [https://docs.hortonworks.com/HDPDocuments/Ambari-2.6.0.0/bk_ambari-installation/content/set_up_the_ambari_server.html](https://docs.hortonworks.com/HDPDocuments/Ambari-2.6.0.0/bk_ambari-installation/content/set_up_the_ambari_server.html)


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

