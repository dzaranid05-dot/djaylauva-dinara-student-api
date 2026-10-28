pipeline {
    agent any
    environment {
        IMAGE = 'djaylauva-dinara-student-api:v1.0-djaylauva-dinara-38086'
    }
    triggers { pollSCM('H/2 * * * *') }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Student: Dinara Djaylauva (ID 38086)'
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean bootJar --no-daemon'
            }
        }
        stage('Test') {
            steps { sh './gradlew test --no-daemon' }
            post { always { junit 'build/test-results/test/*.xml' } }
        }
        stage('Docker Build') {
            steps { sh 'docker build -t $IMAGE .' }
        }
        stage('Verify') {
            steps {
                sh 'docker image inspect $IMAGE --format "Image exists: {{.RepoTags}} size={{.Size}}"'
                echo "Verified image ${IMAGE} for Dinara Djaylauva"
            }
        }
    }
    post {
        success { echo 'SUCCESS: pipeline of Dinara Djaylauva passed' }
        failure { echo 'FAILURE: pipeline of Dinara Djaylauva failed' }
    }
}
