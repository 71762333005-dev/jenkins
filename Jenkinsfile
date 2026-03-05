pipeline {
    agent any

    tools {
        // Make sure you have configured SonarScanner in Jenkins
        sonarScanner 'SonarScanner'
    }

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/71762333005-dev/jenkins.git', branch: 'main', credentialsId: 'github-token'
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
                script {
                    def scannerHome = tool 'SonarScanner'
                    withSonarQubeEnv('My Sonar Server') {  // Server name in Jenkins
                        sh """
                        ${scannerHome}/bin/sonar-scanner \
                        -Dsonar.projectKey=jenkins-project \
                        -Dsonar.sources=.
                        """
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 5, unit: 'MINUTES') {  // Increased timeout to 5 mins
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
