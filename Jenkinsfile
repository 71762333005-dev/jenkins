pipeline {
    agent any

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
            sh '''
            /var/snap/jenkins/4998/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarScanner/bin/sonar-scanner \
            -Dsonar.projectKey=jenkins-project \
            -Dsonar.sources=.
            '''
        }
    }
}

        stage('Deploy') {
            steps {
                sh 'echo Deployment done'
            }
        }
    }
}
