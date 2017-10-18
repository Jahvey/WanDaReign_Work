@echo off
set "rar=C:\Program Files (x86)\WinRAR\WinRAR.exe"
for /r %%i in (*.zip) do (
"%rar%" x -ad -y "%%i"

)
pause