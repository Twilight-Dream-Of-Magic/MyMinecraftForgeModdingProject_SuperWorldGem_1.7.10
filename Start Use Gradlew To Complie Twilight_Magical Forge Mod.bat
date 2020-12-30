@Echo off

Cd /d %~dp0

cmd.exe /k setupDecompWorkspace.bat
cmd.exe /k build.bat


Pause
