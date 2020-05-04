node {
  stage('Git checkout'){
    git 'https://github.com/rdrabina/RapportFileMaker'
  }
  stage('Compile-package'){
    def mvnHome = tool name: 'Maven 3.0.4', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
}
