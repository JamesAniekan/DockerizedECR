pipeline{
    agent any
    tools{
        maven '3.9.4'
    }
    stages{
        stage('Build jar'){
            steps{
                sh 'mvn clean package'
            }
        }
        stage('ECR log in'){
            steps{
                script{
                     withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'awscredentials']]){
                        sh "aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 490098076655.dkr.ecr.us-east-1.amazonaws.com"
                        }
                }
            }
        }
    }
}