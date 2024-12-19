pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    dir('backend') {
                        sh 'chmod +x mvnw'  // Agregar permisos de ejecución a mvnw
                        sh './mvnw clean package'  // Ahora puedes ejecutar mvnw
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    dir('backend') {
                        sh './mvnw test'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    dir('backend') {
                        sh 'java -jar target/*.jar'
                    }
                }
            }
        }
    }
}
