package scripts

class Project {
    final String name
    final Folder parentFolder
    final String defaultBranch
    final String jiraProject
    final String expectedIssueStatus


    Project(Folder parentFolder, String name, String defaultBranch, String jiraProject, String expectedIssueStatus){
        this.parentFolder = parentFolder
        this.name = name
        this.defaultBranch = defaultBranch ?: 'master'
        this.jiraProject = jiraProject
        this.expectedIssueStatus = expectedIssueStatus
    }

    String fullName(){
        "${parentFolder.name}/${name}"
    }
}