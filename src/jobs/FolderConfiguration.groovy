import scripts.Config
import groovy.yaml.YamlSlurper

//todo move config file parsing to Config class .fromFile(String file) factory method
def configFile = new File("config.yml")

configFile.withReader { reader ->
    def config = new YamlSlurper().parse(reader)

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
        folder(projectConf.fullName) {
            properties {

            }
        }
    })
}