pipeline {
    agent any

    stages{
        stage('Test') {
            steps {
                //Get Automation Code from Github
                //echo 'Pull Automation Script from Remote Repository'
                //git 'https://github.com/faromoju/Wema-Assessment-Revised'

                //Start Test Device
                //echo 'Boot Test Device'
                //sh 'emulator @"%DeviceName%"'


                //Start Emulator
                //echo 'Start Device Emulator'
                //bat 'emulator @%DeviceName%'

                //Run Automation Code
                echo 'Run Automation Script'
                bat 'mvn test -PFullFunctionalTest -Dport="%Port%" -DandroidDeviceName="%DeviceName%" -DandroidDeviceUdid="%DeviceId%"'
            }
        }
    }
}