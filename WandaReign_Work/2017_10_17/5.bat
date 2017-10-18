@echo off  
set "file=F:\编程视频\尚硅谷SpringMVC视频教程"
for %%a in (%file%) do for /f "delims=" %%b in ('dir /a-d/b/s *.avi') do (   
echo %%b  
)   
pause