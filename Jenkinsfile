node{


   stage('Build') {
      sh "mvn clean package"
   }

  stage('SonarQube') {
       withSonarQubeEnv('sonar-6') {
           sh 'mvn -Dsonar.branch.name=${BRANCH_NAME} sonar:sonar ' +
           '-f all/pom.xml ' +
           '-Dsonar.language=java ' +
           '-Dsonar.sources=. ' +
           '-Dsonar.tests=. ' +
           '-Dsonar.test.inclusions=**/*Test*/** ' +
           '-Dsonar.exclusions=**/*Test*/**'
       }
   }


    stage("QualityGate") {
          timeout(time: 3, unit: 'MINUTES') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
}