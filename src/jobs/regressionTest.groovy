import scripts.Config

Config.process(config, {}, { projectConf ->
    if(projectConf.generateTestAutomationJobs) {
        pipelineJob("${projectConf.fullName()}/regressionTest"){
            definition {
                cps {
                    script("""
pipeline {
    agent any

    stages {
        stage('Run regression tests') {
            steps {
                script {
                    echo "Runnin regression tests"
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
