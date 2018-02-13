# data-access-service

FROM ubuntu:16.04
MAINTAINER Jaehyeon Kim "dottami@gmail.com"
ENV REFRESHED_AT 2016-09-23

# prevent the following error after adding CRAN source list
# source - http://askubuntu.com/questions/165676/how-do-i-fix-a-e-the-method-driver-usr-lib-apt-methods-http-could-not-be-foun
# E: The method driver /usr/lib/apt/methods/https could not be found.
# E: Failed to fetch https://cran.rstudio.com/bin/linux/ubuntu/xenial/InRelease
# E: Some index files failed to download. They have been ignored, or old ones used instead.
RUN apt-get -yqq update && apt-get -yqq install apt-transport-https

# add CRAN source list
# source - https://cran.rstudio.com/bin/linux/ubuntu/README.html
RUN echo 'deb https://cran.rstudio.com/bin/linux/ubuntu xenial/' >> /etc/apt/sources.list

# prevent GPG error
# source - http://jaehyeon-kim.github.io/2015/11/Connecting-to-VirtualBox-Guest-via-SSH-And-RStudio-Server.html
# W: GPG error: https://cran.rstudio.com/bin/linux/ubuntu xenial/ InRelease: The following signatures couldn't be verified because the public key is not available: NO_PUBKEY 51716619E084DAB9
# W: The repository 'https://cran.rstudio.com/bin/linux/ubuntu xenial/ InRelease' is not signed.
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 51716619E084DAB9

# install r-base and r-base-dev
RUN apt-get -yqq update
RUN apt-get -yqq install ed
RUN apt-get -yqq install libnlopt-dev
RUN apt-get -yqq install r-base r-base-dev

RUN R -e "install.packages('lme4', dependencies = TRUE, repos='https://cran.rstudio.com/')"

RUN apt-get -yqq install openjdk-8-jdk

## add JAVA_HOME
RUN echo 'JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64' >> /etc/environment
RUN /bin/bash -c 'source /etc/environment'

VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

EXPOSE 25000

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]