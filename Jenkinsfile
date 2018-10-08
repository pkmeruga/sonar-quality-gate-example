node{

   stage('Compile-Package'){
      sh "mvn package"
   }

  stage('SonarQube Analysis') {
       withSonarQubeEnv('sonar-6') {
         sh "mvn -Dsonar.branch.name=${BRANCH_NAME} sonar:sonar"
       }
   }


    stage("Quality Gate"){
          timeout(time: 3, unit: 'MINUTES') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
}