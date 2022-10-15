rmdir /s /q platforms node_modules plugins
call cordova prepare
call cd platforms/android/app/src/main/gentool
call npm install
call npm run fixIosSymLinks
call npm run restore
call npm run resize

cd ../tsc
call npm install

cd ../../../../../../
cd platforms/android/app/src/main/gentool
start call npm run start

cd ../tsc
start call npm run build

cd ../../../../../../