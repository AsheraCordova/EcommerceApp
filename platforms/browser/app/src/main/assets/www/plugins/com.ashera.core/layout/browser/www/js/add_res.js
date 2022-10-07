cordova.define("com.ashera.core.layoutAddRes", function(require, exports, module) {
let links = ["css/layout.css"];

for (var i=0;i<links.length;i++) {
	let link = document.createElement('link');
	link.setAttribute('rel', 'stylesheet');
	link.setAttribute('href', links[i]);
	link.setAttribute('type', "text/css");
	window.shadowRoot.appendChild(link);
}
});
