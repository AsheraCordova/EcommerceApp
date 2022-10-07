cordova.define("com.ashera.core.coreManager", function(require, exports, module) {
module.exports = {
    executeCommand: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "CoreCordovaPlugin", "executeCommand", [name]);
    },
    onDeviceReady: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "CoreCordovaPlugin", "onDeviceReady", []);
    },
    navigateCommand: function (commands, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "CoreCordovaPlugin", "navigateCommand", [commands]);
    },
    executeSimpleCommand: function (commands, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "CoreCordovaPlugin", "executeSimpleCommand", commands);
    } 
};
});
