@echo off
::�������ô�ű����ļ���ָ��Ŀ¼·��
::�㶨�ɹ�
::���ִ����ԭ��
::1.Ҫ�������ļ���  Դ�ļ���Ŀ¼�ļ��а�����С����Ϳո񣬽���취�� ������Դ�ļ���·������˫���� ����
set Folder=F:\�����Ƶ\�й��SpringMVC��Ƶ�̳�\videos
set file=F:\�����Ƶ\�й��SpringMVC��Ƶ�̳�

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