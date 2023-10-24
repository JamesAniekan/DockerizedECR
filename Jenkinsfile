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
    }
}