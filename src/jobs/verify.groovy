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
                stage("Unit tests") {
                    echo "Running unit tests.."
                }
            }, 'Static Analysis': { 
                stage("Static analysis") {
                    echo "Running static analysis.."
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
})