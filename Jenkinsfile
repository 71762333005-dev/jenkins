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
                withSonarQubeEnv('My Sonar Server') { // Jenkins Sonar name
                    sh '/var/snap/jenkins/5001/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarScanner/bin/sonar-scanner -Dsonar.projectKey=jenkins-project -Dsonar.sources=.'
                }
            }
        }

 stage('Quality Gate') {
    steps {
        timeout(time: 10, unit: 'MINUTES') {
            script {
                def qg = waitForQualityGate()
                echo "Quality Gate status: ${qg.status}"
            }
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
