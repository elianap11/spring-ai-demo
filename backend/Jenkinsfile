pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    sh './mvnw clean package'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh './mvnw test'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Deploying...'
                }
            }
        }
    }
}
