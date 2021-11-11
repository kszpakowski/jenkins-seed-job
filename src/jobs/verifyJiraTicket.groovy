import scripts.Config

Config.process(config, {}, { projectConf ->
    if(projectConf.expectedIssueStatus) {
        pipelineJob("${projectConf.fullName()}/verifyJiraTicket"){
            definition {
                cps {
                    script("""
pipeline {
    agent any

    stages {
        stage('Verify Jira Ticket') {
            steps {
                script {
                    echo "Checking jira ticket. Jira project: ${projectConf.jiraProject}. Expected status: ${projectConf.expectedIssueStatus}"
                    currentBuild.description="XXX-123"
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
