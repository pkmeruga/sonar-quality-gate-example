node{
   stage('SCM Checkout'){
     git 'https://github.com/pkmeruga/sonar-quality-gate-example.git'
   }
   stage('Compile-Package'){
      sh "mvn package"
   }

  stage('SonarQube Analysis') {
       withSonarQubeEnv('sonar-6') {
         sh "mvn sonar:sonar"
       }
   }


    stage("Quality Gate Statuc Check"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
}