@Echo Off
For /f "tokens=*" %%i in ('dir /ad /b /s "%~dp0"') do (
For /f "tokens=*" %%j in ('dir /a-d /b /s "%%i\*.*"') do (

Move "%%i\%%~nxi%%~xj" "e:\hahaha\"
Rd /q "%%i"))
Pause