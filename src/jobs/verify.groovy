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
                    currentBuild.description = "Verification of MR: ..."
                }
            }
        }
        stage('Test and Analysis') {
            parallel {
                stage("Unit tests") {
                    steps{
                        echo "Running unit tests.."
                    }
                }
                stage("Static analysis") { //static analysis can't run in parallel with tests, as it depends on test cov report
                    steps{
                        echo "Running static analysis.."
                    }
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