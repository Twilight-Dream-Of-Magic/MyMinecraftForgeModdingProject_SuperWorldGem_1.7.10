@Echo Off

:: --gui

Cd /d %~dp0

:: cmd.exe /k .\gradlew.bat setupDecompWorkspace --refresh-dependencies --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat setupDecompWorkspace --refresh-dependencies --full-stacktrace --info

:: cmd.exe /k .\gradlew.bat setupDevWorkspace --refresh-dependencies --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat setupDevWorkspace --refresh-dependencies --full-stacktrace --info

:: cmd.exe /k .\gradlew.bat setupCIWorkspace --refresh-dependencies --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat setupCIWorkspace --refresh-dependencies --full-stacktrace --info

:: cmd.exe /k .\gradlew.bat eclipse --refresh-dependencies --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat eclipse --refresh-dependencies --full-stacktrace --info



:: cmd.exe /k .\gradlew.bat setupDecompWorkspace --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat setupDecompWorkspace --full-stacktrace --info

:: cmd.exe /k .\gradlew.bat setupDevWorkspace --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat setupDevWorkspace --full-stacktrace --info

:: cmd.exe /k .\gradlew.bat setupCIWorkspace --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat setupCIWorkspace --full-stacktrace --info

:: cmd.exe /k .\gradlew.bat eclipse --full-stacktrace --info --offline
:: cmd.exe /k .\gradlew.bat eclipse --full-stacktrace --info

Pause