pipeline {
    agent {
        label 'any' // Tiempo de ejecución en cualquier agente disponible
    }

    stages {
        stage('Build') {
            steps {
                script {
                    dir('backend') { // Navega a la carpeta 'backend'
                        bat 'mvnw.cmd clean package' // Ejecuta mvnw para compilar el proyecto 
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    dir('backend') { // Navega a la carpeta 'backend'
                        bat 'mvnw.cmd test' // Ejecuta las pruebas
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    dir('backend') { // Navega a 'backend'
                        bat 'java -jar target/*.jar' // Ejecuta el jar generado
                    }
                }
            }
        }
    }
}
