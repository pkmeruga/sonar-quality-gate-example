node{
   stage('SCM Checkout'){
     git 'https://github.com/pkmeruga/sonar-quality-gate-example.git'
   }
   stage('Compile-Package'){
      sh "mvn package"
   }
}