pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    dir('backend') { // Navega a la carpeta 'backend'
                        sh './mvnw clean package' // Ejecuta mvnw dentro de 'backend'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    dir('backend') { // Navega nuevamente a 'backend' para pruebas
                        sh './mvnw test'  // Ejecuta las pruebas
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    dir('backend') { // Navega a 'backend' para desplegar
                        // Agrega tus comandos de despliegue aquí
                    }
                }
            }
        }
    }
}
