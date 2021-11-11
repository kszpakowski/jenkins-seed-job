import scripts.Config

Config.process(config,
    { folderConf ->
        folder(folderConf.name) {
            properties {
                authorizationMatrix {
                    inheritanceStrategy {
                        inheriting()
                    }
                    permissions(folderConf.permissions)
                }
            }
        }
    },
    { projectConf ->
        folder(projectConf.fullName()) {
            properties {

            }
        }
    }
)
