import scripts.Config

Config.process(config, {}, { projectConf ->
    pipelineJob("${projectConf.fullName()}/verify"){
        stages {
            stage('Checkout'){
                steps {
                    script {
                        echo "Checking out"
                    }
                }
            }
        }
    }
})