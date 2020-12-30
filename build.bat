::@Echo Off

:: --gui

Cd /d %~dp0

:: cmd.exe /k .\gradlew.bat build --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat build --full-stacktrace --info
cmd.exe /k .\gradlew.bat build --info --offline
::cmd.exe /k .\gradlew.bat build --info

:: cmd.exe /k .\gradlew.bat build --refresh-dependencies --full-stacktrace --info
:: cmd.exe /k .\gradlew.bat build --refresh-dependencie --info

Pause