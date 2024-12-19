pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    dir('backend') { // Navega a la carpeta 'backend'
                        bat 'mvnw.cmd clean package' // Ejecuta mvnw dentro de 'backend'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    dir('backend') {
                        bat 'mvnw.cmd test'
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    dir('backend') { // Navega a 'backend' para desplegar

                    }
                }
            }
        }
    }
}