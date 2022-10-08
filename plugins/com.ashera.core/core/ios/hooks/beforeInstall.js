var fs = require('fs');
var path = require('path');
 
var rootdir = '';
 
function replace_string_in_file(filename, to_replace, replace_with) {
    var data = fs.readFileSync(filename, 'utf8');
    if (data.indexOf(replace_with) == -1) {
    	var result = data.replace(new RegExp(to_replace, "g"), replace_with);
    	fs.writeFileSync(filename, result, 'utf8');
    }
}

const getAllFiles = function(dirPath, filenames, arrayOfFiles) {
  files = fs.readdirSync(dirPath)

  files.forEach(function(file) {
    if (fs.statSync(dirPath + "/" + file).isDirectory()) {
      arrayOfFiles = getAllFiles(dirPath + "/" + file, filenames, arrayOfFiles)
    } else {
      if (filenames.includes(file)) {
      	arrayOfFiles.push(path.join(rootdir, dirPath, "/", file))
      }
    }
  })

  return arrayOfFiles
}

function appendstring_in_file(filename, str) {
    var data = fs.readFileSync(filename, 'utf8');
    if (data.indexOf(str) == -1) {
    	var result = data + '\n' + str;
    	fs.writeFileSync(filename, result, 'utf8');
    }
}
 
var filestoreplace = [
    "platforms/ios",
    "main.m",
    '@"AppDelegate"',
    '@"ASAppDelegate"',
];

var filestoappend = [
	"platforms/ios/cordova/build-debug.xcconfig",
    'J2OBJC_HOME=/Library/j2objc',
	"platforms/ios/cordova/build-debug.xcconfig",
    'HEADER_SEARCH_PATHS = $(inherited) "${J2OBJC_HOME}/include" "${DERIVED_FILES_DIR}";',
	"platforms/ios/cordova/build-debug.xcconfig",
    'LIBRARY_SEARCH_PATHS = $(inherited) "${J2OBJC_HOME}/lib";',
	"platforms/ios/cordova/build-debug.xcconfig",
    'OTHER_LDFLAGS = $(inherited) -l"z" -l"jre_emul" -l"icucore" -l"iconv";',
    
];

filestoreplace.forEach(function(val, index, array) {
	if (index % 4 == 0) {
	    var dir = path.join(rootdir, val);
	    var matchedFiles = [];
	    getAllFiles(dir, [array[index + 1]], matchedFiles)[0];
	    
	    for (let i=0; i<matchedFiles.length;i++) {
	   		var fullfilename = matchedFiles[i];
		    if (fs.existsSync(fullfilename)) {
		    	console.log("file name: "+fullfilename);
		        replace_string_in_file(fullfilename, 
		        	array[index + 2], 
		            array[index + 3]);
		    }
		}
	}
});

filestoappend.forEach(function(val, index, array) {
    var fullfilename = path.join(rootdir, val);
    if (fs.existsSync(fullfilename)) {
    	console.log("file name: "+fullfilename);
        appendstring_in_file(fullfilename,  array[index + 1]);
    }
});
