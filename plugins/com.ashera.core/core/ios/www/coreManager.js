module.exports = {
    executeCommand: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "com.ashera.core.ios", "executeCommand", [name]);
    },
    onDeviceReady: function (successCallback, errorCallback) {
         cordova.exec(successCallback, errorCallback, "com.ashera.core.ios", "onDeviceReady", []);
    },
    navigateCommand: function (commands, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "com.ashera.core.ios", "navigateCommand", [commands]);
    },
    executeSimpleCommand: function (commands, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "com.ashera.core.ios", "executeSimpleCommand", commands);
    } 
};