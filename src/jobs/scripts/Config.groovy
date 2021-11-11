package scripts

class Config{

    public static void process(def config, def Closure folderCallback, def Closure projectCallback){
        processConfig(config, '', folderCallback, projectCallback)
    }

    private void processConfig(def config, def parentFolder='', def Closure folderCallback, def Closure projectCallback){
        config.folders.each() {
            def fullName = "${parent}${it.name}"
            def folder = new Folder(fullName, it.securityGroups)
            folderCallback(folder)
            if(it.folders){
                processConfig(it, "${fullName}/", folderCallback, projectCallback)
            }
            if(it.projects){
                it.projects.each {
                    def project = new Project(folder, it.name, it.defaultBranch)
                }
            }
        }
        
    }
}