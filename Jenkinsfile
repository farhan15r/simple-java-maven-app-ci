pipeline {
    agent {
        docker {
            image 'maven:3.9.0'
            args '--expose 127.0.0.1:8080:8080 -v /root/.m2:/root/.m2'
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
                input message: 'Terima Delivery untuk di Deploy? (Klik "Proceed" untuk terima)'
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
