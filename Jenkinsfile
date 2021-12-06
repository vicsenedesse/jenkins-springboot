pipeline 
{
    agent any

    tools 
    {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }

    stages 
    {
        stage('Build') 
        {
            steps 
            {
                // Get some code from a GitHub repository
                git 'https://github.com/vicsenedesse/jenkins-springboot.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post 
            {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success 
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}



pipeline 
{
    agent any

    tools 
    {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven"
    }

    stages 
    {
        stage('Build') 
        {
            steps 
            {
                // Get some code from a GitHub repository
                git 'https://github.com/vicsenedesse/jenkins-springboot.git'

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"
                sh "mvn clean compile"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
            
        }
        stage('Compile-Package-create-war-file'){
            steps{  
                bat "maven/bin/mvn package"
                
            }
        }
        stage('Test') 
        {
            steps 
            {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                
                //junit '**/target/surefire-reports/TEST-*.xml'
                //archiveArtifacts 'target/*.jar'
                sh "mvn test"
                
            }
        }
        
        stage('Deploy to Tomcat'){
            steps{
                
                bat "copy target/jenkins-springboot.war /opt/tomcat/webapps/jenkins-springboot.war"
            }
        }
        
        stage ('Start Tomcat Server') { 
            steps{
                
                bat "/opt/tomcat/bin/startup.bat"
            }
        }
        
        //stage('Deploy') {
            
        //    steps {
                //echo 'Deploying'
        //        sh "mvn clean deploy -Dmaven.test.skip=true"
        //        bat "copy target\\/jenkins-springboo.war \"${tomcatWeb}\\/jenkins-springboo.war\""
             
        //        bat "${tomcatBin}\\startup.bat"
        //    }
        //}
    }
}

