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
            -Dsonar.sources=. \
            -Dsonar.login=squ_95e5afc880d3dc9261ff6e34c3b22919bd5a9181
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
