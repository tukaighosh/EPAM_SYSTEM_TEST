@ECHO OFF

:: Keep the CMD open on error/success
if not defined in_subprocess (cmd /k set in_subprocess=y ^& %0 %*) & exit )

title Building infra-eureka

call mvn clean install -Dmaven.test.failure.ignore=true %*
