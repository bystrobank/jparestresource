pipeline {
    agent any
    parameters {
        booleanParam(name: "RELEASE",
                description: "Build a release from current commit.",
                defaultValue: false)
    }
    options {
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '3'))
    }
    stages {
        stage ('Build') {
            when {
                not {
                    expression { params.RELEASE }
                }
            }
            steps {
                sh 'mvn -P proc install deploy'
            }
        }
        stage("Release") {
            when {
                expression { params.RELEASE }
            }
            steps {
                sh "mvn -P proc -B release:prepare"
                sh "mvn -P proc -B release:perform"
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}
