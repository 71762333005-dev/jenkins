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
        sh '''
        /var/snap/jenkins/4998/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarScanner/bin/sonar-scanner \
        -Dsonar.projectKey=jenkins-project \
        -Dsonar.sources=. \
        -Dsonar.host.url=http://localhost:9000 \
        -Dsonar.login=squ_883e63a675a6e8df175015182eda8a7bc454c644
        '''
    }
}

        stage('Deploy') {
            steps {
                sh 'echo Deployment done'
            }
        }
    }
}
