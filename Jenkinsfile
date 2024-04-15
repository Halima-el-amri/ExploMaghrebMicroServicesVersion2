pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'dev', url: 'https://github.com/Halima-el-amri/ExploMaghrebMicroServicesVersion2'
            }
        }

        stage('Build Review Service') {
            steps {
                dir('review') {
                    script {
                        if (isUnix()) {
                            sh 'mvn clean install'
                        } else {
                            bat 'mvn clean install'
                        }
                    }
                }
            }
        }

        stage('Build Payment Service') {
            steps {
                dir('payment') {
                    script {
                        if (isUnix()) {
                            sh 'mvn clean install'
                        } else {
                            bat 'mvn clean install'
                        }
                    }
                }
            }
        }


}