import scripts.Config

Config.process(config, {}, { projectConf ->
    if(projectConf.expectedIssueStatus) {
        pipelineJob("${projectConf.fullName()}/verifyJiraTicket"){
            
        }
    }
})
