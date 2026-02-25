pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Source code already checked out by Jenkins'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project...'
                sh 'echo Build successful'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'echo Tests passed'
            }
        }

        stage('Code Quality - SonarQube') {
            steps {
                echo 'Running SonarQube analysis...'
                withSonarQubeEnv('My Sonar Server') {
                    sh 'sonar-scanner'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                sh 'echo Deployment done'
            }
        }
    }

    post {
        success {
            echo 'Pipeline executed successfully'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}
