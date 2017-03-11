#!/usr/bin/groovy
def stage(){
  return stageProject{
    project = 'fabric8io/fabric8-release'
    useGitTagForNextVersion = true
  }
}

def release(project){
  releaseProject{
    stagedProject = project
    useGitTagForNextVersion = true
    helmPush = false
    groupId = 'io.fabric8.release.packages'
    githubOrganisation = 'fabric8io'
    artifactIdToWatchInCentral = 'packages'
    artifactExtensionToWatchInCentral = 'pom'
    promoteToDockerRegistry = 'docker.io'
    dockerOrganisation = 'fabric8'
    imagesToPromoteToDockerHub = []
    extraImagesToTag = null
  }
}


return this;
