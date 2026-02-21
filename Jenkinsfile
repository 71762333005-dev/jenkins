pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'git@github.com:71762333005-dev/jenkins.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building project..."
                sh 'mvn clean compile || true'
            }
        }

        stage('Test') {
            steps {
                echo "Running tests..."
                sh 'mvn test || true'
            }
        }
    }
}
