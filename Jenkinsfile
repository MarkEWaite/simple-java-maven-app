pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn -Dsurefire.rerunFailingTestsCount=10 test'
            }
            post {
                always {
                    junit testDataPublishers: [junitFlakyTestPublisher()], testResults: 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
