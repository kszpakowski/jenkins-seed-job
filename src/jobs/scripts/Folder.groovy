package scripts

class Folder {
    private final String name
    private final List<String> securityGroups

    Folder(String name, List<String> securityGroups){
        this.name = name
        this.securityGroups = securityGroups ?: ['JENKINS_USER']
    }

    String getName(){
        this.@name
    }

    List<String> getPermissions(){
        return [
            'hudson.model.Item.Build',
            'hudson.model.Item.Cancel',
            'hudson.model.Item.Read',
            'hudson.model.Item.Workspace',
            'hudson.model.Run.Delete',
            'hudson.model.Run.Replay',
            'hudson.model.Run.Update',
            'hudson.model.View.Read'
        ].collectMany { permissionName ->
            this.securityGroups.collect { group ->
                "$permissionName:$group"
            }
        }
    }

    @Override
    String toString(){
        return 'Folder{' +
               "name='" + name + "', " +
               "securityGroups='" + securityGroups + "'" +
               '}'
    }
}