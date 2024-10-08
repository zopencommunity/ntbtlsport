node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/ntbtlsport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/ntbtlsport.git'), string(name: 'PORT_DESCRIPTION', value: 'ntbTLS is a tiny TLS 1.2 only implementation designed to be used with Libgcrypt and LibKSBA.' )]
  }
}
