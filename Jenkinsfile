@Library('ceiba-jenkins-library') _
pipeline{

    agent {
        label 'Slave_Induccion'
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
    }

    tools {
        jdk 'JDK8_Centos'
    }

    stages{
        stage('Checkout') {
            steps {
                echo '------------>Checkout desde Git Microservicio<------------'
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    gitTool: 'Default' ,
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: '0ee40853-b086-421b-a1cc-4387f2598986',
                        url: 'https://github.com/carlos-junco/proyectoadnservices.git']]])
                }
        }
        stage('Compilacion y Test Unitarios'){
            steps {
                echo '------------>Test Backend<------------'
                sh 'chmod +x ./apiservicios/gradlew'
                sh './apiservicios/gradlew --b ./apiservicios/build.gradle clean'
                sh './apiservicios/gradlew --b ./apiservicios/build.gradle test'
            }
        }

		stage('Static Code Analysis') {
			steps{
				sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:serviceadn-carlos.junco',
				sonarName:'CeibaADN-serviceadn-Carlos.Junco',
				sonarPathProperties:'./sonar-project.properties')
			}
		}

        stage('Build'){
            steps{
                echo "------------>Compilación backend<------------"
                    sh 'chmod +x ./apiservicios/gradlew'
                    sh './apiservicios/gradlew --b ./apiservicios/build.gradle clean'
                    sh './apiservicios/gradlew --b ./apiservicios/build.gradle build -x test'
                }
            }
        }

    post {
        failure {
            echo 'This will run only if failed'
            mail(
                to: 'carlos.junco@ceiba.com.co',
                body:"Something is wrong with ${env.BUILD_URL}",
                subject: "Failed Pipeline:${currentBuild.fullDisplayName}"
            )
        }
        success {
            echo 'This will run only if successful'
        }
    }
}