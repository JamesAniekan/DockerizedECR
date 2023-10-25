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
        stage('Build and tag image'){
            steps{
                script{
                    sh 'docker build -t mydockerimg .'
                    sh 'docker tag mydockerimg:version1 490098076655.dkr.ecr.us-east-1.amazonaws.com/mydockerimg:version1'
                }
            }
        }
        stage('Push to awsECR'){
            steps{
                script{
                    sh 'docker push 490098076655.dkr.ecr.us-east-1.amazonaws.com/mydockerimg:version1'
                }
            }
        }
    }
}