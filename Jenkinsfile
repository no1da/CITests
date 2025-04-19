pipeline {
    agent {
        label 'docker' // ВАЖНО: Нода должна поддерживать docker и docker-compose
    }

    environment {
        MAVEN_CACHE = "${WORKSPACE}/.m2"  // локальный кеш Maven
        ALLURE_RESULTS_DIR = "${WORKSPACE}/allure-results"
        DOCKER_COMPOSE_FILE = 'docker-compose.yml'
    }

    options {
        skipDefaultCheckout()
        buildDiscarder(logRotator(numToKeepStr: '5'))
        timestamps()
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Prepare workspace') {
            steps {
                sh 'mkdir -p .m2'
                sh 'mkdir -p allure-results'
            }
        }

        stage('Run Tests in Docker') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose up --build --abort-on-container-exit'
            }
        }

        stage('Copy test results') {
            steps {
                // Копируем Allure из контейнера autotests
                sh 'docker cp autotests:/app/allure-results ./allure-results || true'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }

    }

    post {
        always {
            // Вычистить контейнеры и volume'ы
            sh 'docker-compose down -v'
        }
    }
}