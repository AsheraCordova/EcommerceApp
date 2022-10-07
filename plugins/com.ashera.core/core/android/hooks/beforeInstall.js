var fs = require('fs');
var path = require('path');
 
var rootdir = '';

function replace_string_in_file(filename, to_replace, replace_with) {
    var data = fs.readFileSync(filename, 'utf8');
    if (data.indexOf(replace_with) == -1) {
    	var result = data.replace(new RegExp(to_replace.replace(/[.*+?^${}()|[\]\\]/g, '\\$&'), "g"), replace_with);
    	fs.writeFileSync(filename, result, 'utf8');
    }
}

function appendstring_in_file(filename, str) {
    var data = fs.readFileSync(filename, 'utf8');
    if (data.indexOf(str) == -1) {
    	var result = data + '\n' + str;
    	fs.writeFileSync(filename, result, 'utf8');
    }
}
 
var filestoreplace = [
    "platforms/android/CordovaLib/src/org/apache/cordova/CordovaActivity.java",
    "extends Activity",
    "extends androidx.appcompat.app.AppCompatActivity",
    "platforms/android/app/src/main/assets/www/cordova.js",
    "throw new Error('Unknown event action ' + action);",
    "cordova.fireDocumentEvent(action, msg);break;",
     "platforms/android/app/src/main/res/values/strings.xml",
    `<string name="activity_name">@string/launcher_name</string>`,
    `<string name="activity_name">@string/launcher_name</string>
    <string name="error_text">There were errors on the page. Click here to view the same.</string>
    <string name="required_error_message">Should not be empty.</string>
    <string name="max_length_error_message">Maximum number of characters allowed is %d.</string>
    <string name="min_length_error_message">Minimum number of characters required is %d.</string>
    <string name="max_value_error_message">Max value allowed is %d.</string>
    <string name="min_value_error_message">Min value required is %d.</string>
    <string name="pattern_error_message">Invalid format specified.</string>
    <string name="url_error_message">Please enter valid url.</string>
    <string name="alphabets_error_message">Please enter only Alphabets.</string>
    <string name="alphanumeric_error_message">Please enter only alphanumeric characters.</string>
    <string name="date_error_message">Invalid date format.</string>
    <string name="inrange_error_message">Number must be between %d and %d.</string>
    <string name="email_error_message">Invalid email address.</string>
    <string name="mobile_error_message">Invalid Mobile number.</string>
    <string name="number_error_message">Must be number.</string>
    <string name="positivenumber_error_message">Should be positive integer.</string>
    <string name="pincode_error_message">Must be valid pincode.</string>
    <string name="length_between_error_message">Number length must be between %d and %d.</string>
    <string name="length_atmost_error_message">Number should be atmost %d.</string>
    <string name="length_atleast_error_message">Number should be atleast %d.</string>
    <string name="strongpassword_error_message">Password should contains atleast 8 characters, one uppercase letter, number and special character.</string>
    <string name="default_textOff">OFF</string>
    <string name="default_textOn">ON</string>`
];

var filestoappend = [
    "platforms/android/CordovaLib/build.gradle",
    "apply from: 'cordovalib.gradle'"
];

filestoreplace.forEach(function(val, index, array) {
    var fullfilename = path.join(rootdir, val);
    if (fs.existsSync(fullfilename)) {
    	console.log("file name: "+fullfilename);
        replace_string_in_file(fullfilename, 
        	array[index + 1], 
            array[index + 2]);
    }
});

filestoappend.forEach(function(val, index, array) {
    var fullfilename = path.join(rootdir, val);
    if (fs.existsSync(fullfilename)) {
    	console.log("file name: "+fullfilename);
        appendstring_in_file(fullfilename,  array[index + 1]);
    }
});