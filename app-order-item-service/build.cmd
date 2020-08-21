@ECHO OFF

:: Keep the CMD open on error/success
if not defined in_subprocess (cmd /k set in_subprocess=y ^& %0 %*) & exit )

title Building app-order-item-service

call mvn clean install -Dmaven.test.failure.ignore=true %*
