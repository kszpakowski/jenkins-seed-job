import scripts.Config

Config.process(config, {}, { projectConf ->
    pipelineJob("${projectConf.fullName()}/verify"){
        
    }
})