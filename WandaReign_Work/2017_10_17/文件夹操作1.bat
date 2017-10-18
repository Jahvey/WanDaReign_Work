@echo off
::这里设置存放备份文件的指定目录路径
set Folder=e:\wang1
set file=F:\编程视频\尚硅谷SpringMVC视频教程
::set Local=F:\编程视频\尚硅谷SpringMVC视频教程
::mkdir %Folder%
::if exist list.txt ( del list.txt ) 
IF NOT EXIST %Folder% MD %Folder%


goto my
for /r  %cd% %%i in (*.avi) do (
   echo  %%i
   copy  %%i  "%Folder%\"
   
)
:my



for %%a in (%file%) do for /f "delims==" %%b in ('dir /a-d/b/s *.avi') do (   
echo %%a
	::echo %%b
	echo ------
	type %%b
	echo =========
	copy  %%b  "%Folder%\"
	echo *********
)  



echo success!



pause