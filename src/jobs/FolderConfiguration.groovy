import scripts.Config

def config = readYaml (file: 'config.yaml')

println config
/*
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
*/