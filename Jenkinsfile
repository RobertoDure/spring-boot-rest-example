pipeline {
    agent any
    tools{
        maven 'mvn'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RobertoDure/spring-boot-rest-example.git']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t robertodure/spring-boot-rest-example .'
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                   sh 'docker login -u robertodure -p ${dockerhubpwd}'

}
                   sh 'docker push robertodure/spring-boot-rest-example'
                }
            }
        }
    }
}