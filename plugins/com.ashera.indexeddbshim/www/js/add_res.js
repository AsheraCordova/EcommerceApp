if (!window.indexedDB) {
	window.openDatabase = require('cordova-plugin-sqlite-2.sqlitePlugin').openDatabase;
	document.body.appendChild(document.createElement("script")).src = "js/indexeddbshim.min.js";
}
