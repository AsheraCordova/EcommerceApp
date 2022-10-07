const plist = require("simple-plist");
var fs = require('fs');
var path = require('path');
let et = require('elementtree');

let config_xml = path.join("../../../../../../", 'config.xml');
let data = fs.readFileSync(config_xml).toString();
let etree = et.parse(data);
let appId = etree.getroot().attrib.id ;
let appName = etree.getroot().find('name')['text'];
var plistPath = "../../../../../../platforms/ios/" + appName + "/" + appName + "-Info.plist";
var fontPath = "../../../../../../platforms/android/app/src/main/res/font";

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

