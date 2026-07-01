pipeline {
    agent any

    stages {
        stage('Clonar código') {
            steps {
                checkout scm
            }
        }

        stage('Compilar e gerar WAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Deploy no Tomcat da máquina') {
            steps {
                sh '''
                echo "Copiando WAR para o Tomcat..."
                sudo cp target/webapp.war /var/lib/tomcat10/webapps/webapp.war
                sudo systemctl restart tomcat10
                echo "Deploy finalizado. Acesse: http://localhost:8080/webapp"
                '''
            }
        }
    }

    post {
        success {
            echo 'BUILD SUCCESS - Aplicação publicada no Tomcat.'
        }
        failure {
            echo 'Falha no pipeline. Verifique o Console Output.'
        }
    }
}
