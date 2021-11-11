import scripts.Config

Config.process(config, {}, { projectConf ->
    if(projectConf.generateTestAutomationJobs) {
        pipelineJob("${projectConf.fullName()}/performanceTest"){
            definition {
                cps {
                    script("""
pipeline {
    agent any

    stages {
        stage('Run performance tests') {
            steps {
                script {
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
