import scripts.Config

Config.process(config, {}, { projectConf ->
    pipelineJob("${projectConf.fullName()}/verify"){
        definition {
            cps {
                script("""
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    echo "Checking out.."
                    
                }
            }
        }
        stage('Test and Analysis') {
            parallel 'Unit Tests': {
                echo "Running unit tests.."
            }, 'Static Analysis': { 
                echo "Running Static Analysis"
            }

        }
    }
}
                """)
                sandbox()
            }
        }
    }
})