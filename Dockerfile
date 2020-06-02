FROM tomcat:8.5.16-jre8-alpine
EXPOSE 8080
ENV DB_URL=''
ENV DB_PORT=''
ENV DB_DB_USERNAME=''
ENV DB_PASSWORD=''
RUN rm -fr /usr/local/tomcat/webapps/ROOT
COPY ./target/ROOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]