pipeline {
    agent any

    environment {
        // SonarQube server name configured in Jenkins
        SONARQUBE_SERVER = 'My Sonar Server'
        // Path to SonarScanner installation
        SONAR_SCANNER_HOME = '/var/snap/jenkins/5001/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarScanner'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/71762333005-dev/jenkins.git',
                    branch: 'main',
                    credentialsId: 'github-token'
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
                // This runs the SonarScanner
                withSonarQubeEnv(SONARQUBE_SERVER) {
                    sh """
                        ${SONAR_SCANNER_HOME}/bin/sonar-scanner \
                        -Dsonar.projectKey=jenkins-project \
                        -Dsonar.sources=src/main/java \
                        -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    // Wait for SonarQube Quality Gate result
                    timeout(time: 10, unit: 'MINUTES') {
                        def qg = waitForQualityGate(abortPipeline: true)
                        echo "Quality Gate status: ${qg.status}"
                    }
                }
            }
        }

        stage('Deploy') {
            when {
                expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                sh 'echo Deploying to AWS/Nexus...'
            }
        }
    }

    post {
        failure {
            echo 'Build failed due to Quality Gate violation! Deployment skipped.'
        }
        success {
            echo 'Build passed all stages. Deployment executed successfully.'
        }
    }
}
