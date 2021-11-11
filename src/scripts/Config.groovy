package scripts

import groovy.yaml.YamlSlurper

class Config{

    private final def config

    private Config(def config){
        this.config = config
    }

    public static void fromFile(String configFilePath){
        def configFile = new File(configFilePath)
        configFile.withReader { reader ->
            def config = new YamlSlurper().parse(reader)
            return new Config(config)
        }
    }

    public void process(def parentFolder='', def Closure folderCallback, def Closure projectCallback){
        config.folders.each() {
            def fullName = "${parent}${it.name}"
            def folder = new Folder(fullName, it.securityGroups)
            folderCallback(folder)
            if(it.folders){
                process(it, "${fullName}/", folderCallback, projectCallback)
            }
            if(it.projects){
                it.projects.each {
                    def project = new Project(folder, it.name, it.defaultBranch)
                }
            }
        }
        
    }
}