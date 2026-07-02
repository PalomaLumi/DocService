# Imagem com Apache Tomcat e Java 17
FROM tomcat:10.1-jdk17-temurin

# Remove aplicações padrão do Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia o WAR gerado pelo Maven para dentro do Tomcat
# O nome webapp.war faz a aplicação abrir em /webapp
COPY target/webapp.war /usr/local/tomcat/webapps/webapp.war

# Porta interna do Tomcat
EXPOSE 8181

CMD ["catalina.sh", "run"]
