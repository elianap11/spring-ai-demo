pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    dir('backend') { // Navega a la carpeta 'backend'
                        sh './mvnw clean package' // Ejecuta mvnw para compilar el proyecto (usando sh en lugar de bat)
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    dir('backend') { // Navega a la carpeta 'backend'
                        sh './mvnw test' // Ejecuta las pruebas (usando sh)
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    dir('backend') { // Navega a 'backend'
                        sh 'java -jar target/*.jar' // Ejecuta el jar generado (usando sh)
                    }
                }
            }
        }
    }
}
