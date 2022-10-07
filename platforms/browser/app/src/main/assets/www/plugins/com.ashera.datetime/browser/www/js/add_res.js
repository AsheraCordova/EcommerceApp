cordova.define("com.ashera.datetime.datetimeAddRes", function(require, exports, module) {
document.body.appendChild(document.createElement("script")).src = "js/date-time-picker.min.js";
let links = ["css/date-time-picker.min.css"];

for (var i=0;i<links.length;i++) {
	let link = document.createElement('link');
	link.setAttribute('rel', 'stylesheet');
	link.setAttribute('href', links[i]);
	link.setAttribute('type', "text/css");
	document.body.appendChild(link);
}
});
