@echo off

set "Folder=F:\�����Ƶ\����������㷨ȫ��\3���ѧϰ������ǿ��\videos"
set "file=F:\�����Ƶ\����������㷨ȫ��\3���ѧϰ������ǿ��"

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