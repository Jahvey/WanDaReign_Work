@echo off
::这里设置存放备份文件的指定目录路径
set Folder=e:\BackupFiles111
  
for /f "delims=" %%a in ('dir /ad/b') do (
    pushd "%%~a"
    for /f "delims=" %%b in ('dir /a-d/b/o-n') do set "file=%%~b"
    copy "%file%" "%Folder%\"
    popd
)
pause