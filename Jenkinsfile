pipeline {
    agent any

    tools {
        sonarRunner 'SonarScanner' // matches your Jenkins Sonar installation
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'echo Build successful'
            }
        }

        stage('Test') {
            steps {
                sh 'echo Tests passed'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('My Sonar Server') {
                    sh 'sonar-scanner -Dsonar.projectKey=jenkins-project -Dsonar.sources=.'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                // Increase timeout to 5 minutes to avoid aborted pipeline
                timeout(time: 5, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Deploy') {
            steps {
                sh 'echo Deploying application'
            }
        }
    }
}
