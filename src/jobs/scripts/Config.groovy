package scripts

class Config{

    private final def config

    private Config(def config){
        this.config = config
    }

    public static void fromFile(String configFilePath){
        def config = readYaml (file: configFilePath)
        return new Config(config)
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