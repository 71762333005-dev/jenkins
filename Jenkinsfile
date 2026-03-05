pipeline {
    agent any

    environment {
        // This must match the SonarQube installation name in Jenkins
        SONARQUBE_ENV = 'My Sonar Server'
    }

    stages {
        stage('Checkout SCM') {
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
                // Inject SonarQube environment
                withSonarQubeEnv("${SONARQUBE_ENV}") {
                    sh """
                    /var/snap/jenkins/5001/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarScanner/bin/sonar-scanner \
                    -Dsonar.projectKey=jenkins-project \
                    -Dsonar.sources=.
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                // Wait for SonarQube Quality Gate result
                timeout(time: 5, unit: 'MINUTES') {
                    script {
                        def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to failed Quality Gate: ${qg.status}"
                        }
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                sh 'echo Deploying to production...'
            }
        }
    }
}
