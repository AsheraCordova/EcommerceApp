var fs = require('fs');
var path = require('path');

var copyRecursiveSync = function(src, dest) {
  var exists = fs.existsSync(src);
  
  var stats = exists && fs.statSync(src);
  var isDirectory = exists && stats.isDirectory();
  console.log(src);
  if (isDirectory) {
  	fs.mkdirSync(path.resolve(dest), {recursive: true});
    fs.readdirSync(src).forEach(function(childItemName) {
      copyRecursiveSync(path.join(src, childItemName),
                        path.join(dest, childItemName));
    });
  } else {
  	var exists = fs.existsSync(dest);
  	if (!exists) {
    	fs.copyFileSync(src, dest);
    }
  }
};
 
copyRecursiveSync("plugins/com.ashera.core/core/android/res-onetime", "platforms/android/app/src/main/res");
copyRecursiveSync("plugins/com.ashera.core/core/android/tsc-onetime", "platforms/android/app/src/main/tsc");