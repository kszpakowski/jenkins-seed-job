pipeline {
    agent any

    stages {
        stage('Check out'){
            steps {
                git branch: 'main',
                    url: 'https://github.com/kszpakowski/jenkins-seed-job.git'
            }
        }
        stage('Process jobs') {
            steps {
                script {
                    jobDsl targets: ['src/jobs/FolderConfiguration.groovy','src/jobs/**.groovy'].join('\n'),
                      removedJobAction: 'DELETE',
                      removedViewAction: 'DELETE',
                      removedConfigFilesAction: 'DELETE',
                      lookupStrategy: 'JENKINS_ROOT',
                      sandbox: true,
                      additionalParameters: [:]
                }
            }
        }
    }
}
