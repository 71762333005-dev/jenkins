pipeline {
    agent any

    tools {
        jdk 'OpenJDK 17' // Make sure you have a JDK configured in Jenkins
    }

    environment {
        SONAR_HOST_URL = 'http://127.0.0.1:9000'
        SONAR_SCANNER_HOME = '/var/snap/jenkins/5001/tools/hudson.plugins.sonar.SonarRunnerInstallation/SonarScanner'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/71762333005-dev/jenkins.git', branch: 'main', credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling Java code...'
                sh 'mkdir -p target/classes'        // create output folder
                sh 'javac -d target/classes src/main/java/*.java'  // compile all Java files
            }
        }

        stage('Test') {
            steps {
                echo 'Skipping tests for now...'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('My Sonar Server') {
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
                    // Wait up to 10 minutes for SonarQube analysis to finish
                    timeout(time: 10, unit: 'MINUTES') {
                        def qg = waitForQualityGate(abortPipeline: true)
                        echo "Quality Gate status: ${qg.status}"
                        // abortPipeline: true ensures Jenkins fails the build automatically
                    }
                }
            }
        }

        stage('Deploy') {
            when {
                expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
            }
            steps {
                echo 'Deploying to AWS/Nexus...'
            }
        }
    }

    post {
        failure {
            echo 'Build failed due to Quality Gate violation! Deployment skipped.'
        }
    }
}
