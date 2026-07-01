# Projeto Spring Boot WAR - Jenkins + Tomcat + Docker

Projeto simples para demonstrar Integração Contínua com:

- Java 17
- Spring Boot
- Maven
- Empacotamento `.war`
- Jenkins Pipeline
- Apache Tomcat instalado na máquina
- Dockerfile com Tomcat

## 1. Gerar o WAR localmente

```bash
mvn clean package -DskipTests
```

O arquivo será criado em:

```bash
target/webapp.war
```

## 2. Rodar no Tomcat da máquina

Copie o WAR para o Tomcat:

```bash
sudo cp target/webapp.war /var/lib/tomcat10/webapps/webapp.war
sudo systemctl restart tomcat10
```

Acesse:

```text
http://localhost:8080/webapp
```

Endpoint de teste:

```text
http://localhost:8080/webapp/status
```

## 3. Usar no Jenkins

No Jenkins, crie um item do tipo **Pipeline**.

Em **Definition**, escolha:

```text
Pipeline script from SCM
```

Em **SCM**, escolha:

```text
Git
```

Em **Repository URL**, coloque a URL do seu repositório GitHub.

Em **Branch Specifier**, coloque:

```text
*/main
```

Em **Script Path**, coloque:

```text
Jenkinsfile
```

Clique em **Save** e depois em **Build Now**.

## 4. Permissão do Jenkins para copiar no Tomcat

Execute no Linux:

```bash
sudo visudo
```

No final do arquivo, adicione:

```bash
jenkins ALL=(ALL) NOPASSWD: /bin/cp, /bin/systemctl
```

## 5. Rodar com Docker localmente

```bash
mvn clean package -DskipTests
docker build -t webapp-springboot-tomcat .
docker rm -f webapp-container || true
docker run -d --name webapp-container -p 8181:8080 webapp-springboot-tomcat
```

Acesse:

```text
http://localhost:8181/webapp
```

## 6. Alterar a versão para gerar novos prints

Edite o arquivo:

```text
src/main/java/br/com/exemplo/webapp/HomeController.java
```

Troque:

```java
private static final String VERSAO = "v1.0";
```

Para:

```java
private static final String VERSAO = "v1.1";
```

Depois faça:

```bash
git add .
git commit -m "Atualiza versão da aplicação"
git push
```

No Jenkins, rode **Build Now** novamente.
