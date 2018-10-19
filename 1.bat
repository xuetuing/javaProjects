@echo off
set "d1=d:\a"
set "d2=d:\b"
cd /d %d1%
for /f "delims=" %%a in ('dir/b "%d1%\*"') do (
if not exist "%d2%\%%~nxa" xcopy /y/e "%%a" "%d2%\%%~nxa"
)
pause