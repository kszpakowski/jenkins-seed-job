package scripts

class Project {
    final String name
    final Folder parentFolder
    final String defaultBranch


    Project(Folder parentFolder, String name, String defaultBranch){
        this.parentFolder = parentFolder
        this.name = name
        this.defaultBranch = defaultBranch ?: 'master'
    }
}