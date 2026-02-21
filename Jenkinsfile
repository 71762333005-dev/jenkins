pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/71762333005-dev/jenkins.git',
                    credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project'
            }
        }

        stage('Test') {
            steps {
                echo 'Testing project'
            }
        }
    }
}
