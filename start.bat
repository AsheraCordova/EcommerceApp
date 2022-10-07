call cd platforms/android/app/src/main/gentool
REM call npm install
REM call npm run resize
start call npm run start

cd ../tsc
REM call npm install
start call npm run build

cd ../../../../../../
 