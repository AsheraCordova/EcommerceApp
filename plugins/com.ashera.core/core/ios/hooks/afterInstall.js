const plist = require("simple-plist");
var xcode = require('xcode');
var util = require('util');
var fs = require('fs');
var path = require('path');

 
var rootdir = '';
var f = util.format;

module.exports = (context) => {
	const { ConfigParser } = context.requireCordovaModule("cordova-common");
  	const appConfig = new ConfigParser(path.resolve(context.opts.projectRoot, "config.xml"));
  	const appName = appConfig.name();
  	console.log(appName);
  	projectPath = 'platforms/ios/' + appName + '.xcodeproj/project.pbxproj';
	myProj = xcode.project(projectPath);
	var plistPath = "platforms/ios/" + appName + "/" + appName + "-Info.plist";
	var fontPath = "platforms/android/app/src/main/res/font";
	//fs.copyFileSync("plugins/com.ashera.core.ios/build.xml", "platforms/ios/build.xml");
	
	//27E45212286452BC00FEBE6F /* color */ = {isa = PBXFileReference; lastKnownFileType = folder; name = color; path = resources/color; sourceTree = "<group>"; };
	myProj.parse(function (err) {
		
		var baseNames = ['drawable-ios', 'color', 'xml', 'menu', 'drawable', 'values', 'font'];
		var group = 'Resources';
		for (var i = 0; i < baseNames.length; i++) {
			var baseName = baseNames[i];
			var uuid = myProj.generateUuid();
			var commentKey = f("%s_comment", uuid);
			var longComment = f("%s in %s", baseName, group);
			var path = "../../../android/app/src/main/resources/" + baseName;
			
			if (baseName == 'drawable-ios') {
				path = "../../../android/app/src/main/res-ios/" + baseName;
			}

			if (baseName == 'font') {
				path = "../../" + baseName;
			}			
		    
		    var found = false;
		    for (j in myProj.pbxFileReferenceSection()) {
		        if (myProj.pbxFileReferenceSection()[j].path == path) {
		            console.log("ignored " + baseName);
		            found = true;
					break;
		        }
		    }
		    
			if (!found) {
				myProj.pbxFileReferenceSection()[uuid] = {
			        isa: "PBXFileReference",
			        name: baseName,
			        path: path,
			        sourceTree: '"<group>"',
			        lastKnownFileType: "folder"
			    };
			
			 	
			    myProj.pbxFileReferenceSection()[commentKey] = baseName;
			    var pluginsGroup = myProj.pbxGroupByName(group);
			    pluginsGroup.children.push({
			        value: uuid,
			        comment: baseName
				});
				
				
				var builduuid = myProj.generateUuid();
				var buildcommentKey = f("%s_comment", builduuid);
				myProj.pbxBuildFileSection()[builduuid] = {
			        isa : 'PBXBuildFile',
			        fileRef : uuid,
			        fileRef_comment: baseName
				};
				myProj.pbxBuildFileSection()[buildcommentKey] = longComment;
				myProj.addToPbxResourcesBuildPhase({
					"basename": baseName,
					"group": group,
					"uuid":  builduuid
				}); 
			}
		}
		fs.writeFileSync(projectPath, myProj.writeSync());
	});
	
	
	function callback(err, data) {
	  if (err) throw err;
	  
	  var fontLst = [];
	  fs.readdir(fontPath, (err, files) => {
		  files.forEach(file => {
		    if (!file.endsWith(".xml")) {
	    		fontLst.push("font/" + file);
	    	}
		  });
		  data["UIAppFonts"] = fontLst;
	  	  plist.writeFile(plistPath, data, function() {
		});
	  
	  });
	
	}

	// read
	plist.readFile(plistPath, callback);
}	