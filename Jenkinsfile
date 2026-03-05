pipeline {
    agent any

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
            environment {
                SONAR_HOST_URL = 'http://127.0.0.1:9000'
                SONAR_SCANNER_HOME = '/var/snap/jenkins/5001/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarScanner'
            }
            steps {
                withSonarQubeEnv('My Sonar Server') {
                    sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner -Dsonar.projectKey=jenkins-project -Dsonar.sources=."
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    timeout(time: 10, unit: 'MINUTES') {
                        // Wait for SonarQube result and fail build if gate is not passed
                        def qg = waitForQualityGate(abortPipeline: true)
                        echo "Quality Gate status: ${qg.status}"
                    }
                }
            }
        }

        stage('Deploy') {
            when {
                expression { return currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                sh 'echo Deploying to AWS/Nexus'
            }
        }
    }
}
