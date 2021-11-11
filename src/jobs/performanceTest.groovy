import scripts.Config

Config.process(config, {}, { projectConf ->
    if(projectConf.generateTestAutomationJobs) {
        pipelineJob("${projectConf.fullName()}/performanceTest"){
            parameters {
                choiceParam('Environment_param',['Dev','Test'])
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
                    echo "Runnin performance tests on \${Environment_param} env."
                    currentBuild.description="Env: \${Environment_param}"
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
