pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/71762333005-dev/jenkins.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building project..."
            }
        }

        stage('Test') {
            steps {
                echo "Running tests..."
            }
        }
    }
}
