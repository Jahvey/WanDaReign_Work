@echo off

set "Folder=F:\编程视频\深度神经网络算法全套\3深度学习深入与强化\videos"
set "file=F:\编程视频\深度神经网络算法全套\3深度学习深入与强化"

IF NOT EXIST "%Folder%" MD "%Folder%"




for %%a in (%file%) do for /f "delims=" %%b in ('dir /a-d/b/s *.avi') do (   


	echo =========
	copy  "%%b"  "%Folder%\"
	echo copy success!
	del  "%%b"
	echo del file success!
	echo *********
)  

echo success!

pause