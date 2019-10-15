FROM openjdk:8-jre-alpine
ENV LANG ko_KR.UTF-8
ENV LANGUAGE ko_KR:en
ENV LC_ALL ko_KR.UTF-8

MAINTAINER NexCloud

VOLUME /tmp
ADD ./target/NexclipperFullfillment-0.0.1.war NexclipperFullfillment.war
RUN sh -c 'touch /NexclipperFullfillment.war'

ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.131-3.b12.el7_3.x86_64/jre/
ENV PATH=$JAVA_HOME/bin:$PATH
  
ENV JAVA_OPTS=""
#CMD exec java  -Djava.security.egd=file:/dev/./urandom -jar /NexclipperFullfillment.war

CMD exec java -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:InitiatingHeapOccupancyPercent=70 -XX:NewRatio=2 -XX:SurvivorRatio=6 -XX:G1ReservePercent=10 -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled -Djava.security.egd=file:/dev/./urandom -jar /NexclipperFullfillment.war