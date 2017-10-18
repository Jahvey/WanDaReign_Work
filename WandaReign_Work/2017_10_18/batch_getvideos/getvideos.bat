@echo off
::这里设置存放备份文件的指定目录路径
::搞定成功
::出现错误的原因：
::1.要拷贝的文件中  源文件的目录文件中包含有小数点和空格，解决办法是 将整个源文件的路径加上双引号 即可
set Folder=e:\wang2
set file=F:\编程视频\动力节点-王勇-SSH框架视频教程[共享完毕]\hibernate\vedio

IF NOT EXIST %Folder% MD %Folder%




for %%a in (%file%) do for /f "delims=" %%b in ('dir /a-d/b/s *.avi') do (   

	::echo ------
	::type "%%b"
	echo =========
	copy  "%%b"  "%Folder%\"
	del  "%%b"
	echo *********
)  

echo success!

pause