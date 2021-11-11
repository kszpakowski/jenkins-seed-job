import scripts.Config

Config.fromFile('config.yaml').process(
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
        folder(projectConf.fullName) {
            properties {

            }
        }
    }
)
