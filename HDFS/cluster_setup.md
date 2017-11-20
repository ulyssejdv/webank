# How to setup the webank HDFS cluster

## Hosts
 
On each host, run the following commands :

`sudo apt-get update`

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

## Ambari Configuration 


References :

- [https://www.digitalocean.com/community/tutorials/how-to-install-hadoop-in-stand-alone-mode-on-ubuntu-16-04](https://www.digitalocean.com/community/tutorials/how-to-install-hadoop-in-stand-alone-mode-on-ubuntu-16-04)