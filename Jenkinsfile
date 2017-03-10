#!/usr/bin/groovy
@Library('github.com/fabric8io/fabric8-pipeline-library@master')
def releaseVersion
 mavenNode {
   ws{
     try {
       checkout scm
       readTrusted 'release.groovy'
       sh "git remote set-url origin git@github.com:fabric8io/fabric8-release.git"
       def pipeline = load 'release.groovy'

      def stagedProject
       stage ('Stage'){
          stagedProject = pipeline.stage()
          releaseVersion = stagedProject[1]
       }
       
       stage ('Approve'){
          pipeline.approve(stagedProject)
       }

       stage ('Promote'){
          pipeline.release(stagedProject)
       }
       
     } catch (err){
       hubot room: 'release', message: "${env.JOB_NAME} failed: ${err}"
       error "${err}"
    }
  }
}

