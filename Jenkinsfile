pipeline {
    agent {
    label 'windows' 
}


    stages {
        stage('Build') {
            steps {
                script {
                    dir('backend') { // Navega a la carpeta 'backend'
                        sh 'chmod +x mvnw' // Asegura que mvnw tenga permisos de ejecución
                        sh './mvnw clean package' // Ejecuta mvnw para compilar el proyecto
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    dir('backend') { // Navega a la carpeta 'backend'
                        sh './mvnw test' // Ejecuta las pruebas
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    dir('backend') { // Navega a 'backend'
                        // Asumiendo que tienes un jar generado en target/
                        sh 'java -jar target/*.jar' // Ejecuta el jar para desplegar la app
                    }
                }
            }
        }
    }
}
