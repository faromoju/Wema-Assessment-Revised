pipeline {
    agent any

    stages{
        stage('Test') {
            steps {
                //Start Emulator
                echo 'Start Device Emulator'
                bat 'start cmd.exe /k emulator @%DeviceName%'

                //Run Automation Code
                echo 'Run Automation Script'
                bat 'mvn test -PFullFunctionalTest -Dport="%Port%" -DandroidDeviceName="%DeviceName%" -DandroidDeviceUdid="%DeviceId%"'
            }
        }
    }
}