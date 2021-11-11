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
                script {
                    echo "Runnin performance tests"
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
