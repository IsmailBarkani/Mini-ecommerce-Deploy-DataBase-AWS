FROM tomcat:8.5.16-jre8-alpine
EXPOSE 8080
RUN rm -fr /usr/local/tomcat/webapps/ROOT
COPY ./target/ROOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]