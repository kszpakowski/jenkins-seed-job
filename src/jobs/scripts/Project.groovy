package scripts

class Project {
    final String name
    final Folder parentFolder
    final String defaultBranch
    final String jiraProject
    final String expectedIssueStatus
    final bool generateTestAutomationJobs


    Project(Folder parentFolder, String name, String defaultBranch, String jiraProject, String expectedIssueStatus, bool generateTestAutomationJobs){
        this.parentFolder = parentFolder
        this.name = name
        this.defaultBranch = defaultBranch ?: 'master'
        this.jiraProject = jiraProject
        this.expectedIssueStatus = expectedIssueStatus
        this.generateTestAutomationJobs = generateTestAutomationJobs
    }

    String fullName(){
        "${parentFolder.name}/${name}"
    }
}