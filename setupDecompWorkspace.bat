@Echo Off

:: --gui

Cd /d %~dp0

:: cmd.exe /k .\gradlew.bat setupDecompWorkspace --refresh-dependencies --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat setupDecompWorkspace --refresh-dependencies --full-stacktrace --info

:: cmd.exe /k .\gradlew.bat setupDecompWorkspace --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat setupDecompWorkspace --full-stacktrace --info

:: cmd.exe /k .\gradlew.bat eclipse --refresh-dependencies --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat eclipse --refresh-dependencies --full-stacktrace --info

:: cmd.exe /k .\gradlew.bat eclipse --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat eclipse --full-stacktrace --info

Pause