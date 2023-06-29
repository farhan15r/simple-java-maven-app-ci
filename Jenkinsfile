pipeline {
    agent {
        docker {
            image 'maven:3.9.0'
            args '-p 8080:8080 -v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/farhan15r/simple-java-maven-app-ci.git'
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Deploy') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
