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
        withSonarQubeEnv('My Sonar Server') {
            sh """
            ${tool 'SonarScanner'}/bin/sonar-scanner \
            -Dsonar.projectKey=jenkins-project \
            -Dsonar.sources=.
            """
        }
    }
}
        stage("Quality Gate") {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
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
