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

                stage('Build customer-service') {
                    steps {
                        dir('customer-service') {
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

                stage('Test customer-service') {
                    steps {
                        dir('customer-service') {
                            script {
                                if (isUnix()) {
                                    sh 'mvn test'
                                } else {
                                    bat 'mvn test'
                                }
                            }
                        }
                    }
                }




            stage('Build booking service') {
                            steps {
                                dir('booking-service') {
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

                        stage('Test booking service') {
                            steps {
                                dir('booking-service') {
                                    script {
                                        if (isUnix()) {
                                            sh 'mvn test'
                                        } else {
                                            bat 'mvn test'
                                        }
                                    }
                                }
                            }
                        }



        stage('Build Review Service') {
            steps {
                dir('review-service') {
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

        stage('Test Review Service') {
            steps {
                dir('review-service') {
                    script {
                        if (isUnix()) {
                            sh 'mvn test'
                        } else {
                            bat 'mvn test'
                        }
                    }
                }
            }
        }


        stage('Build notification Service') {
                    steps {
                        dir('notification-service') {
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

      stage('Test notification Service') {
                    steps {
                        dir('notification-service') {
                            script {
                                if (isUnix()) {
                                    sh 'mvn test'
                                } else {
                                    bat 'mvn test'
                                }
                            }
                        }
                    }
                }


       stage('Build  Guide Service') {
                                    steps {
                                        dir('GuidOfCityService') {
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

       stage('Test  Guide Service') {
                                    steps {
                                        dir('GuidOfCityService') {
                                            script {
                                                if (isUnix()) {
                                                    sh 'mvn test'
                                                } else {
                                                    bat 'mvn test'
                                                }
                                            }
                                        }
                                    }
                                }


       stage('Build  GuidTour Service') {
                                    steps {
                                        dir('GuidTour') {
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

        stage('Test  GuidTour Service') {
                                    steps {
                                        dir('GuidTour') {
                                            script {
                                                if (isUnix()) {
                                                    sh 'mvn test'
                                                } else {
                                                    bat 'mvn test'
                                                }
                                            }
                                        }
                                    }
                                }
        stage('Build Payment Service') {
            steps {
                dir('payment-service') {
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

        stage('Test Payment Service') {
            steps {
                dir('payment-service') {
                    script {
                        if (isUnix()) {
                            sh 'mvn test'
                        } else {
                            bat 'mvn test'
                        }
                    }
                }
            }
        }
    }
}