import scripts.Config

Config.process(config, {}, { projectConf ->
    if(projectConf.generateTestAutomationJobs) {
        pipelineJob("${projectConf.fullName()}/performanceTest"){
            parameters {
                choiceParam('Environment',['Dev','Test'])
            }
            definition {
                cps {
                    script("""
pipeline {
    agent any

    stages {
        stage('Run performance tests') {
            steps {
                sh env
                script {
                    echo "Runnin performance tests on ${env.Environment} env."
                    currentBuild.description="Env: ${env.Environment}"
                }
            }
        }
    }
}
                    """)
                    sandbox()
                }
            }
        }
    }
})
