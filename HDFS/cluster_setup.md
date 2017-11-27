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

`ssh-keygen

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
