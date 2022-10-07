let cpx = require("cpx");
let watch = require('node-watch');
let fs = require('fs');
let path = require('path');
let { xsltProcess, xmlParse } = require('xslt-processor');
var parser = require('./xml2json');
var sizeOf = require('image-size');

// generate file on startup
// create folders
createFolders();
fs.readdirSync("../res/values").forEach(file => {
	generateFile(`..${path.sep}res${path.sep}values${path.sep}${file}`);
});	
fs.readdirSync("../res/").forEach(dir => {
	fs.readdirSync("../res/" + dir).forEach(file => {
		generateFile(`..${path.sep}res${path.sep}${dir}${path.sep}${file}`);
	});
});

syncPlatformRes();


watch('../assets/www/js', { recursive: true }, function (evt, name) {
    syncBundleJs();
});
watch('../res', { recursive: true }, function (evt, name) {
	if (name.endsWith("___")) {
		return;
	}

	if (name == `..${path.sep}res${path.sep}layout`) {
		return;
	}
	try {
		generateFile(name);
		syncPlatformRes();
	} catch (err) {
		console.log(err);
	}
});

function syncPlatformRes() {
	// android file
	cpx.copy("../res/layout/*.xml", "../assets/www/layout");

	syncSwtRes();
	syncWebRes();
	syncIosRes();
	syncToWWW();
	updateDrawableSize();
}

function syncSwtRes() {
	let swtResPath = "../../../../../swt/app/src/main/resources";
	let swtAssetPath = "../../../../../swt/app/src/main/assets";
	if (fs.existsSync(swtResPath)) {
		console.log("swt sync");
		syncRes(swtResPath, swtAssetPath);
		cpx.copySync(swtAssetPath + "../../../../../res/xml/config.xml", swtResPath + "/res/xml/");
	}
}

function syncToWWW() {
	let projectBasePath = "../../../../../../";
	// css and language.properties and index.js
	cpx.copySync("../assets/www/css/*.*", projectBasePath + "/www/css");
	cpx.copySync("../assets/www/layout/*.*", projectBasePath + "/www/layout");
	cpx.copySync("../assets/www/language.properties", projectBasePath + "/www");
	cpx.copySync("../assets/www/js/index.js", projectBasePath + "/www/js");
	cpx.copySync("../assets/www/img/*", projectBasePath + "/www/img");
}


function syncIosRes() {
	let iosPath = "../../../../../ios/";

	if (fs.existsSync(iosPath)) {
		// res - layout,font
		cpx.copySync("../res/layout/*.xml", iosPath + "/www/layout");
		cpx.copySync("../res/font/*.*", iosPath + "/font");
		cpx.copySync("../resources/font/*.*", iosPath + "/font");

		// css and language.properties and index.js
		cpx.copySync("../assets/www/css/*.*", iosPath + "/www/css");
		cpx.copySync("../assets/www/language.properties", iosPath + "/www");
		cpx.copySync("../assets/www/js/index.js", iosPath + "/www/js");
	}
}


function syncRes(baseResPath, baseAssetPath) {
	// res - layout,font
	cpx.copySync("../res/layout/*.xml", baseResPath + "/www/layout");
	cpx.copySync("../res/font/*.*", baseAssetPath + "/www/res/font");

	// all resources
	cpx.copySync("../resources/**/*.*", baseResPath + "/");

	// css and language.properties and index.js
	cpx.copySync("../assets/www/css/*.*", baseResPath + "/www/css");
	cpx.copySync("../assets/www/css/*.*", baseAssetPath + "/www/css");
	cpx.copySync("../assets/www/language.properties", baseResPath + "/www");
	cpx.copySync("../assets/www/js/index.js", baseAssetPath + "/www/js");

	// drawable
	cpx.copySync("../res-swt/drawable/*.png", baseAssetPath + "/www/res-swt/drawable");

	//splash screen assets
	if (fs.existsSync("../res/drawable-port-hdpi")) {
		cpx.copySync("../res/drawable-port-hdpi/*.png", baseAssetPath + "/www/res-swt/drawable");
	}
}

function syncWebRes() {
	let webPath = "../../../../../browser/app/src/main/resources";
	let webAssetPath = "../../../../../browser/app/src/main/assets";
	if (fs.existsSync(webPath)) {
		console.log("web sync");
		syncRes(webPath, webAssetPath);	
		cpx.copySync(webAssetPath + "../../../../../res/xml/config.xml", webAssetPath + "/www/");
		cpx.copySync(webAssetPath + "../../../../../res/xml/config.xml", webPath + "/res/xml/");
	}
}

function syncBundleJs() {
	let swtPath = "../../../../../swt/app/src/main/assets";
	if (fs.existsSync(swtPath)) {
		console.log("bundle swt sync");
		cpx.copy("../assets/www/js/index.js", swtPath + "/www/js");
	}
	
	let webPath = "../../../../../browser/app/src/main/assets";
	if (fs.existsSync(webPath)) {
		console.log("bundle web sync");
		cpx.copy("../assets/www/js/index.js", webPath + "/www/js");
	}
	
	let iosPath = "../../../../../ios/app/src/main/assets";
	if (fs.existsSync(iosPath)) {
		console.log("bundle ios sync");
		cpx.copy("../assets/www/js/index.js", iosPath + "/www/js");
	}
	
	let projectBasePath = "../../../../../../";
	cpx.copySync("../assets/www/js/index.js", projectBasePath + "/www/js");
}
function createFolders() {
	let resMandatory = [
		"../res-swt/",
		"../resources/drawable",
		"../resources/values",
		"../resources/xml",
		"../resources/color",
		"../resources/menu",
		"../tsc/src/R"
	];

	for (let res in resMandatory) {
		if (!fs.existsSync(resMandatory[res])) {
			fs.mkdirSync(resMandatory[res], { recursive: true });
		}
	}
}

function generateFile(name) {
	//console.log(name);
	let respath = `..${path.sep}res${path.sep}`;
	let pathArr = name.split(path.sep);
	let dirName = pathArr[pathArr.length - 2];
	let fileName = pathArr[pathArr.length - 1];

	if (name.startsWith(respath + 'drawable') && name.indexOf(".xml") != -1) {
		console.log("xslt triggered " + name);
		let outFileName = fileName.replace('.xml', ".json");
		runXmlToJson(name, "../resources/drawable/" + outFileName);
		sortAndConcatDrawableXmlFiles();
	}

	if (dirName == 'drawable' || name == 'drawable-mdpi') {
		updateExtension("drawable");
		updateExtension("drawable-mdpi");
		sortAndConcatDrawableXmlFiles();
	}

	if (name.startsWith(respath + 'menu') && name.indexOf(".xml") != -1) {
		console.log("xslt triggered " + name);
		let outFileName = fileName.replace('.xml', ".json");
		runXmlToJson(name, "../resources/menu/" + outFileName);
		sortAndConcatMenuFiles();
	}

	if (name.startsWith(respath + 'xml' + path.sep + 'recyclerview_') && name.indexOf(".xml") != -1) {
		console.log("xslt triggered " + name);
		let outFileName = fileName.replace('.xml', ".json");
		runXmlToJson(name, "../resources/xml/" + outFileName);
		sortAndConcatRecylerFiles();
	}

	if (name == respath + 'values' + path.sep + 'colors.xml') {
		console.log("xsl triggered" + name);
		runXSLT(name, "colors.xsl", '../resources/color/color_tmp.properties');
		sortAndConcatColorXmlFiles();
	}

	if (name.startsWith(respath + 'color') && name.indexOf(".xml") != -1) {
		console.log("xslt triggered " + name);
		let outFileName = fileName.replace('.xml', ".json");
		//runXSLT(name, "xml-to-json.xsl", "../resources/color/" + outFileName);
		runXmlToJson(name, "../resources/color/" + outFileName);
		sortAndConcatColorXmlFiles();
	}

	if (name.startsWith(respath + 'values') && name.indexOf("strings.xml") != -1) {
		console.log("xslt triggered" + name);
		runXSLT(name, "strings.xsl", getStringFileName(dirName));
	}

	if (name.startsWith(respath + 'values') && name.indexOf("styles.xml") != -1) {
		console.log("stylesheet transformation triggered" + name);
		runXSLT(name, "styles.xsl", "../assets/www/css/" + dirName + ".css");
		sortAndConcatStyleFile();
	}

	if (name == respath + 'values' + path.sep + 'dimens.xml') {
		console.log("xsl triggered" + name);
		runXSLT(name, "dimens.xsl", '../resources/values/dimens.properties');
	}

	if (name == respath + 'values' + path.sep + 'system_style.xml') {
		console.log("xsl triggered" + name);
		runXSLT(name, "theme.xsl", '../resources/values/theme.properties');
		runXSLT(name, "theme_widgetoverride.xsl", "../assets/www/language.properties");
	}

	if (name.startsWith(respath + 'font') && name.indexOf(".xml") != -1) {
		console.log("xslt triggered " + name);
		let outFileName = fileName.replace('.xml', ".properties");
		runXSLT(name, "font.xsl", "../resources/font/font_" + outFileName);

		let outCssFileName = fileName.replace('.xml', ".css");
		console.log("xslt triggered " + outCssFileName);
		runXSLT(name, "fontcss.xsl", "../assets/www/css/font_" + outCssFileName);
	}

	if (name.startsWith(respath + 'layout')) {
		console.log("copy triggered" + name);
		cpx.copy("../res/layout/*.xml", "../assets/www/layout");

		let outFileName = fileName.replace('.xml', ".ts");
		let finalOutputFile = getCamelCaseFileName(outFileName);
		runXSLT(name, "id.xsl", "../tsc/src/R/" + finalOutputFile, true);

		runXSLT(name, "fragment.xsl", "../tsc/src/" + finalOutputFile, false, true);
	}

	if (name.startsWith(respath + 'navigation') && name.indexOf(".xml") != -1) {
		console.log("xslt triggered " + name);
		let outFileName = fileName.replace('.xml', ".ts");
		let finalOutputFile = getCamelCaseFileName(outFileName);
		runXSLT(name, "nav_graph.xsl", "../tsc/src/R/" + finalOutputFile);
	}

	// fragment mapper
	var files = '<Files>';
	fs.readdirSync("../res/layout").forEach(file => {
		var tsFileName = getCamelCaseFileName(file).replace('.xml', "");
		if (fs.existsSync("../tsc/src/" + tsFileName + ".ts")) {
			files += `<File name="${tsFileName}" path="${file}" />`;
		}
	});
	files += '</Files>';
	runXSLTOnStr(files, "fragmentmapper.xsl", "../tsc/src/FragmentMapper.ts", false, true);
	
	//font file
	sortAndConcatFontCssFiles();
}

function sortAndConcatFontCssFiles() {
	let dir = '../assets/www/css/';
	let finalColorFile = '../assets/www/css/font.css';
	let files = fs.readdirSync(dir);
	fs.writeFileSync(finalColorFile, "");

	let str = '';
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];
		
		if (fileName.startsWith("font_") && fileName.endsWith(".css")) {
			str += fs.readFileSync(dir + fileName);
			str += '\n';
		}
	}
	
	fs.writeFileSync(finalColorFile, str);
}

function getCamelCaseFileName(outFileName) {
	let split = outFileName.split("_");
	let finalOutputFile = '';
	for (let i = 0; i < split.length; i++) {
		finalOutputFile += split[i].substring(0, 1).toUpperCase() + split[i].substring(1);
	}

	return finalOutputFile;
}

function runXSLTOnStr(xmlString, xslPath, outputFilePath, removeDuplicateLines, merge) {
	let xsltString = fs.readFileSync(xslPath, "utf8");
	let xml = xmlParse(xmlString); // xmlString: string of xml file contents
	let xslt = xmlParse(xsltString); // xsltString: string of xslt file contents
	let text = xsltProcess(xml, xslt); // outXmlString: output xml string.
	//console.log(outputFilePath);

	text = text.replace(/&gt;/gi, ">");
	text = text.replace(/&lt;/gi, "<");	

	if (removeDuplicateLines) {
		text = text.replace(/&amp;#xa;/gi, "");
		let unique = text.split(';').filter((item, i, ar) => ar.indexOf(item) === i);
		text = unique.join(";\n");
	}

	if (text.trim() == '') {
		console.log("ignoring file write" + outputFilePath);
		return;
	}
	if (merge) {
		if (fs.existsSync(outputFilePath)) {
			let originalFile = fs.readFileSync(outputFilePath, "utf8");
			text = mergeStrings(originalFile, text);
		}
	}


	fs.writeFileSync(outputFilePath, text.replace(/&amp;#xa;/gi, "\n"));
}

function runXSLT(xmlPath, xslPath, outputFilePath, removeDuplicateLines, merge) {
	let xmlString = fs.readFileSync(xmlPath, "utf8");
	runXSLTOnStr(xmlString, xslPath, outputFilePath, removeDuplicateLines, merge);
}

function runXmlToJson(xmlPath, outputFilePath) {
	let xmlString = fs.readFileSync(xmlPath, "utf8");
	xmlString = xmlString.replace(/->/gi, "####");
	var json = parser.xml2json(xmlString); 	
	var str = JSON.stringify(json);
	str = str.replace(/####/gi, "->");
	fs.writeFileSync(outputFilePath, str);
}

function getStringFileName(dirName) {
	let out;
	let split = dirName.indexOf("-");
	if (split == -1) {
		out = "../resources/values/strings.properties"
	} else {
		out = "../resources/values/strings_" + dirName.replace(/values-/gi, "").replace(/\\-/gi, "_") + ".properties";
	}
	return out;
}
String.prototype.lpad = function (padString, length) {
	let str = this;
	while (str.length < length)
		str = padString + str;
	return str;
}

function getName(name) {
	name = replaceAllWithPadding(name, "([0-9]+)");
	if (name == "values.css") {
		return "00" + name;
	}

	if (name == "values-land.css") {
		return "01" + name;
	}
	if (name == "values-port.css") {
		return "01" + name;
	}

	return "03" + name;
}

function replaceAllWithPadding(name, regex) {
	let strArr = name.split(/([0-9]+)/gi);
	let finalStr = "";
	for (let j = 0; j < strArr.length; j++) {
		let myStr = strArr[j];
		if (!isNaN(myStr)) {
			myStr = myStr.lpad("0", 5)
		}

		finalStr += myStr;
	}
	return finalStr;

}

function sortAndConcatRecylerFiles() {
	let dir = '../resources/xml/';
	let finalColorFile = '../resources/xml/recycler.properties';
	let files = fs.readdirSync(dir);
	fs.writeFileSync(finalColorFile, "");

	let str = '';
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];
		if (fileName.indexOf(".json") != -1) {
			str += fileName.replace(".json", "");
			str += '=';
			str += fs.readFileSync(dir + fileName);
			str += '\n';
		}
	}
	fs.writeFileSync(finalColorFile, str);
}
function sortAndConcatMenuFiles() {
	let dir = '../resources/menu/';
	let finalColorFile = '../resources/menu/menu.properties';
	let files = fs.readdirSync(dir);
	fs.writeFileSync(finalColorFile, "");

	let str = '';
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];
		if (fileName.indexOf(".json") != -1) {
			str += fileName.replace(".json", "");
			str += '=';
			str += fs.readFileSync(dir + fileName);
			str += '\n';
		}
	}
	fs.writeFileSync(finalColorFile, str);
}
function sortAndConcatColorXmlFiles() {
	let colorContent = fs.readFileSync("../resources/color/color_tmp.properties")
	let dir = '../resources/color/';
	let finalColorFile = '../resources/color/color.properties';
	let files = fs.readdirSync(dir);
	fs.writeFileSync(finalColorFile, "");

	let str = colorContent;
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];
		if (fileName.indexOf(".json") != -1) {
			str += fileName.replace(".json", "");
			str += '=';
			str += fs.readFileSync(dir + fileName);
			str += '\n';
		}
	}
	fs.writeFileSync(finalColorFile, str);
}

function sortAndConcatDrawableXmlFiles() {
	let dir = '../resources/drawable/';
	let finalColorFile = '../resources/drawable/drawable.properties';
	let files = fs.readdirSync(dir);
	fs.writeFileSync(finalColorFile, "");

	let str = '';
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];
		if (fileName.indexOf("_ext.properties") != -1 || fileName.indexOf("_size.properties") != -1) {
			str += fs.readFileSync(dir + fileName);
		}
		if (fileName.indexOf(".json") != -1) {
			str += fileName.replace(".json", "");
			str += '=';
			str += fs.readFileSync(dir + fileName);
			str += '\n';
		}
	}
	fs.writeFileSync(finalColorFile, str);
}

function sortAndConcatStyleFile() {
	let dir = '../assets/www/css'; // your directory

	let files = fs.readdirSync(dir);
	files.sort(function (a, b) {
		return getName(a).localeCompare(getName(b));
	});

	fs.writeFileSync('../assets/www/css/styles.css', "");
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];

		if (fileName.startsWith("values")) {
			if (fileName.indexOf("-") != -1) {
				writeToStyleCss('@media only screen and ');
				let strs = fileName.replace(".css", "").split(/-/gi);
				let seperator = '';
				for (let k = 0; k < strs.length; k++) {
					let str = strs[k];
					if (str != "values") {
						if (str.startsWith("w")) {
							writeToStyleCss("(min-width : " + str.substring(1) + ")");
							seperator = ' and '
						}

						if (str.startsWith("h")) {
							writeToStyleCss(seperator + "(min-height : " + str.substring(1) + ")");
						}

						if (str.startsWith("land")) {
							writeToStyleCss(seperator + "(orientation: landscape)");
						}

						if (str.startsWith("port")) {
							writeToStyleCss(seperator + "(orientation: portrait)");
						}
					}
				}
				writeToStyleCss(' {');
			}

			// And write data from the input into the output
			writeToStyleCss(fs.readFileSync("../assets/www/css/" + fileName) + "\n");

			if (fileName.indexOf("-") != -1) {
				writeToStyleCss('}' + '\n');
			}
		}
	}
}

function writeToStyleCss(str) {
	fs.appendFileSync('../assets/www/css/styles.css', str);
}
function mergeStrings(originalFile, code) {
	var finalStr = '';
	var keyWords = ["body", "import", "className"];
	var startPrefix = "//start - ";
	var endPrefix = "//end - ";
	for (var j = 0; j < keyWords.length; j++) {
		var keyword = keyWords[j];

		var startKeyWord = startPrefix + keyword;
		var endKeyWord = endPrefix + keyword;

		var startOrig = originalFile.indexOf(startKeyWord);
		var endOrig = originalFile.indexOf(endKeyWord);
		var startFinal = code.indexOf(startKeyWord);
		var endFinal = code.indexOf(endKeyWord);
		if (startOrig != -1) {
			finalStr = originalFile.substring(0, startOrig) +
				code.substring(startFinal, endFinal) +
				originalFile.substring(endOrig, originalFile.length);
			originalFile = finalStr;
		} else {
			finalStr = originalFile;
		}
	}
	return finalStr;
}

function updateExtension(dirName) {
	let files = fs.readdirSync(`../res/${dirName}`);
	let str = '';
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];
		var j = fileName.lastIndexOf('.');
		var fileExt = fileName.substr(j  + 1);
		if (fileName.endsWith(".9.png")) {
			fileExt = "9.png";
			j--;
			j--;
		}
		str += fileName.substr(0, j) + "_ext=" + fileExt + '\n';
	}

	fs.writeFileSync(`../resources/drawable/${dirName}_ext.properties`, str);
}

function updateDrawableSize() {
	let drawableSizeFile = '../resources/drawable/drawable_size.properties';
	let files = fs.readdirSync("../res-swt/drawable/");
	fs.writeFileSync(drawableSizeFile, "");
	var str = '';
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];
		var j = fileName.lastIndexOf('.');
		var fileExt = fileName.substr(j  + 1);
		if (fileName.endsWith(".9.png")) {
			fileExt = "9.png";
			j--;
			j--;
		}
		var dimensions = sizeOf('../res-swt/drawable/' + fileName);
		str += fileName.substr(0, j) + ".width=" + dimensions.width + '\n';
		str += fileName.substr(0, j) + ".height=" + dimensions.height + '\n';
	}

	fs.writeFileSync(`../resources/drawable/drawable_size.properties`, str);	
}

