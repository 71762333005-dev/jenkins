pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://github.com/71762333005-dev/jenkins.git', branch: 'main'
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
                    withSonarQubeEnv('My Sonar Server') {
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
               timeout(time: 5, unit: 'MINUTES') { // increased from 2 to 5
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
