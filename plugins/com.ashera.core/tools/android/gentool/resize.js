var im = require('imagemagick');
var resolve = require('path').resolve
var gm = require('gm').subClass({imageMagick: true});
require('gm-base64');
var fs = require('fs');

resizeStart();
async function resizeStart() {
	var baseDir = '../res/drawable-xxxhdpi/';
	let files = fs.readdirSync(baseDir);
	let destDir = ['../res-ios/drawable-ios/', '../res-swt/drawable/', '../res/drawable-ldpi/', '../res/drawable-mdpi/', '../res/drawable-hdpi/', '../res/drawable-xhdpi/', '../res/drawable-xxhdpi/'];
	let percentages = ['37.5%', '15%', '18.75%', '25%', '37.5%', '50%', '75%'];
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];
		
		for (let j = 0; j < destDir.length; j++) {
			var destPath =  resolve(destDir[j] + fileName);
			var dir = resolve(destDir[j]);
			if (!fs.existsSync(dir)){
    			fs.mkdirSync(dir, { recursive: true });
			}
			console.log(destPath);
			let percentage = percentages[j];
			if (fileName.indexOf("_no_resize.") != -1) {
				percentage = "100%";
			}
			await resize(resolve(baseDir + fileName), destPath, percentage);
		}
	}

	baseDir = '../res/drawable/';
	files = fs.readdirSync(baseDir);
	destDir = ['../res-ios/drawable-ios/', '../res-swt/drawable/'];
	percentages = ['100%', '60%'];
	var nine_patch_base64 = '';
	for (let i = 0; i < files.length; i++) {
		let fileName = files[i];
		if (fileName.endsWith(".png")) {
			for (let j = 0; j < destDir.length; j++) {
				var destPath =  resolve(destDir[j] + fileName);
				var dir = resolve(destDir[j]);
				if (!fs.existsSync(dir)){
	    			fs.mkdirSync(dir, { recursive: true });
				}
				console.log(destPath);
				await resize(resolve(baseDir + fileName), destPath, percentages[j]);
				
			  	if (fileName.endsWith(".9.png")) {
			  		var finalFileName = fileName.replace(".9.png", "_9.png");
			  		var size = await getSize(destPath);
			  		await crop(size.width - 2, size.height - 2, 1, 1, destPath, destDir[j] + "/" + finalFileName);
			  		/*if (j == 1) {
			  			var base64 = await getBase64(destDir[j] + "/" + finalFileName);
						var key = fileName.replace(".9.png", "_9") + "_base64=";
						nine_patch_base64 += key + base64 + "\n";
					}*/
				}
			}
		}
	}
	//fs.writeFileSync( '../resources/drawable/drawable_ninepatch_ext.properties', nine_patch_base64);
}

async function getBase64(path) {
	return new Promise(function(resolve, reject) {
		gm(path).toBase64('png', true, function(err, base64){
			if (err) {
				reject(err);
			} else {
				resolve(base64);
			}
		});
	});
}

async function crop(width, height, x, y, srcPath, dstPath) {
	return new Promise(function(resolve, reject) {
		gm(srcPath).crop(width, height, x, y).write(dstPath, function (err) {
			if (err) {
				reject(err);
			} else {
				resolve();
			}
		});
	});
}
async function getSize(path) {
	return new Promise(function(resolve, reject) {
		gm(path).size(function (err, size) {
			if (err) {
				reject(err);
			} else {
				resolve(size);
			}
		});
	});
}
async function resize(srcPath, dstPath, percentage) {
	return new Promise(function(resolve, reject) {
		im.resize({
		  srcPath: srcPath,
		  dstPath: dstPath,
		  width:   percentage
		}, function(err, stdout, stderr){
			if (err) {
				reject(err);
			} else {
				resolve(dstPath);
			}
		});
	});
}
