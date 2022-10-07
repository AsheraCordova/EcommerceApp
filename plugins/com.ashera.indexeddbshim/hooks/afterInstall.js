var fs = require('fs');

module.exports = (context) => {
	fs.copyFileSync("plugins/com.ashera.indexeddbshim/www/js/indexeddbshim.min.js", "platforms/ios/www/js/indexeddbshim.min.js");
}	