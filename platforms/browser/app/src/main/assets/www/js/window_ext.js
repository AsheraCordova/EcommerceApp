	(function(){
	  let stateSymbol = "__state__index__";
	  history.stateIndex =-1;
	  history.states=[];
	  let pushState = history.pushState;
	  function add(data,title,url){
	    if(data==null) data={};
	    if(typeof data!="object") data={data:data};
	    data[stateSymbol] = (history.stateIndex+1);
	    history.states.splice(history.stateIndex+1,0,[data,title,url])
	    history.states.splice(history.stateIndex+2)
	    history.stateIndex++;
	  }
	  history.pushState =function(data,title,url=null){
	    add(data,title,url);
	    pushState.bind(history)(data,title,url);
	  }
	  addEventListener("popstate",function(e){
	    var eventObject= {};
	    var newStateIndex =  e.state!=null ? e.state[stateSymbol] : -1;
	    eventObject.from = history.states[history.stateIndex];
	    eventObject.to   = newStateIndex>-1 ? history.states[newStateIndex] : null;
	    eventObject.side = history.stateIndex>newStateIndex ? "back" : "forward"; 
	    if (e.state != null) {
	    	eventObject.state = JSON.stringify(e.state);
	    }
	    if( newStateIndex > -1 && !(newStateIndex in history.states) ){
	      add(history.state,"",window.location.href);
	    }
	    window.dispatchEvent(new CustomEvent("historyChange", {detail: eventObject} ))
	    history.stateIndex = e.state!=null ? e.state[stateSymbol] : -1;
	  });
	})();

    var offscreenLabelW = {};
    
    window.prompt = function(arg1, arg2) {
    	var event = new CustomEvent('prompt');
	   	event.arg1 = arg1;
	   	event.arg2 = arg2;
	   	console.log(arg1 + arg2);
    	window.dispatchEvent(event);
    	console.log("args " + "  " + arg1 + arg2);
    	console.log("result " + "  " + window.promptResult);
    	return window.promptResult;
    }
    function hideWidget(label) {
    		label.style.position = 'absolute';
    		label.style.left="-999999px";
    }
    
    function copyStyleAttr(cachedLabel, label, measureWidth) {
       	cachedLabel.style.font = label.style.font;
    	cachedLabel.style.fontSize = label.style.fontSize;
    	cachedLabel.style.fontFamily = label.style.fontFamily;
    	cachedLabel.style.fontWeight = label.style.fontWeight;
    	cachedLabel.style.wordBreak=label.style.wordBreak;
    	cachedLabel.style.whiteSpace=label.style.whiteSpace;
    	cachedLabel.style.letterSpacing=label.style.letterSpacing;
    	cachedLabel.style.lineHeight=label.style.lineHeight;
    	cachedLabel.style.resize=label.style.resize;
		cachedLabel.style.border = label.style.border;
    	cachedLabel.style.outline=label.style.outline;
    	cachedLabel.innerHTML = label.innerHTML;
    	
    	var tagName = label.tagName;
    	if (tagName.toUpperCase() === 'INPUT') {
    		cachedLabel.style.minWidth = "0px";
    	} else if (tagName.toUpperCase() === 'TEXTAREA') {
    		cachedLabel.style.overflow = "hidden";
    		if (measureWidth) {
				cachedLabel.style.width = '0px';    			
    			cachedLabel.wrap = "off";
    		} else {
    			cachedLabel.style.height = '0px';
    			cachedLabel.wrap = label.wrap;
    			
    			if (cachedLabel.wrap === 'off') {
    				cachedLabel.style.overflow = "auto";
    				cachedLabel.style.height = "auto";
    			}
    		}

    		cachedLabel.rows = "1";
    		cachedLabel.style.padding = label.style.padding;
			cachedLabel.value = label.value;
			
    		if (label.value == '' && label.placeholder != '') {
    			cachedLabel.value = label.placeholder;
    		}
    	} else if (tagName.toUpperCase() === 'SELECT' && label.hasAttribute('multiple')) {
    		cachedLabel.size = label.options.length;
    	} else if (tagName.toUpperCase() === 'SELECT' && !label.hasAttribute('multiple')) {
    		cachedLabel.removeAttribute('size');
    	}
    	
    	
    	if (tagName.toUpperCase() === 'INPUT') {
    		cachedLabel.value = label.value;
			
    		if (label.value == '' && label.placeholder != '') {
    			cachedLabel.value = label.placeholder;
    		}
    	}
    }
    window.nativeMeasureWidth = function(label, ignorePadding) {
    	var tagName = label.tagName;
    	var cachedLabel =  offscreenLabelW[tagName];
    	if (!cachedLabel) {
    		cachedLabel = document.createElement(tagName);
    		cachedLabel.style.height = 'auto';
    		cachedLabel.style.width = 'auto';
    		hideWidget(cachedLabel);
    		offscreenLabelW[tagName]  = cachedLabel;
    		window.shadowRoot.appendChild(cachedLabel);
	    }
	    
	    copyStyleAttr(cachedLabel, label, true);
	    if (tagName.toUpperCase() === 'INPUT') {
	    	if (cachedLabel.scrollWidth > cachedLabel.clientWidth) {
    			cachedLabel.style.minWidth = (cachedLabel.scrollWidth + 1) + "px";
    		}
    	}
	    if (tagName.toUpperCase() === 'TEXTAREA') {
			cachedLabel.style.width = (cachedLabel.scrollWidth + 1) + "px";
		}
		var paddingLeft = 0;
		var paddingRight = 0;
		if (!ignorePadding) {
			paddingRight= parseInt(label.style.paddingRight) || 0;
			paddingLeft= parseInt(label.style.paddingLeft) || 0;
		}
		var clientWidth = cachedLabel.getBoundingClientRect().width + 1;
        var width = Math.ceil(clientWidth + paddingLeft + paddingRight);
    	return width;
    };
    var offscreenLabelH = {};
    window.nativeMeasureHeight = function(label, width, ignorePadding) {
    	var tagName = label.tagName;
    	var cachedLabel =  offscreenLabelH[tagName];
    	if (!cachedLabel) {
    		cachedLabel = document.createElement(tagName);
    		cachedLabel.style.height = 'auto';
    		hideWidget(cachedLabel);
			offscreenLabelH[tagName]  = cachedLabel;
        	window.shadowRoot.appendChild(cachedLabel);
	    }

    	copyStyleAttr(cachedLabel, label, false);
    	cachedLabel.style.width = width;
    	
		if (tagName.toUpperCase() === 'TEXTAREA') {
			if (cachedLabel.wrap !== 'off') {
				cachedLabel.style.height = (cachedLabel.scrollHeight + 1) + "px";
			} else {
				if (cachedLabel.scrollWidth <= cachedLabel.clientWidth) {
					cachedLabel.style.overflow = 'hidden';
				}
			}
		}		
		
		var paddingTop = 0;
		var paddingBottom = 0;
		if (!ignorePadding) {
			paddingTop= parseInt(label.style.paddingTop) || 0;
			paddingBottom= parseInt(label.style.paddingBottom) || 0;
		}
		var clientHeight = cachedLabel.offsetHeight;
        var height = Math.ceil(clientHeight + paddingTop + paddingBottom);
    	return height;
    };
    
    	
	window.getLineHeight = function(label) {
    	var tagName = label.tagName;
    	var cachedLabel =  offscreenLabelW[tagName];
		
    	if (!cachedLabel) {
    		cachedLabel = document.createElement(tagName);
    		hideWidget(cachedLabel);
    		offscreenLabelW[tagName]  = cachedLabel;
    		window.shadowRoot.appendChild(cachedLabel);
	    }
	    
	    copyStyleAttr(cachedLabel, label, false);
	    
	    cachedLabel.style.height = 'auto';
    	cachedLabel.style.width = 'auto';
    	cachedLabel.innerHTML = 'A';

		var clientHeight = cachedLabel.clientHeight;
    	var height = Math.ceil(clientHeight);
    	return height;
	}

    	
	window.getScreenWidth = function() {
		return 400;
	}
	
	window.getScreenHeight = function() {
		return 600;
	}
	
	window.getNewInputValueOnPaste = function (e) {
		var clipboardData = e.clipboardData || window.clipboardData;
    	var pastedData = clipboardData.getData('Text');
		var value = e.target.value, idx = e.target.selectionStart, key = pastedData;
        value =  value.slice(0, idx) + key + value.slice(idx + Math.abs(0));
        return value;
	}
	
	window.getNewInputValueOnCut = function (e) {
		var value = e.target.value, idx = e.target.selectionStart, idxEnd = e.target.selectionEnd;
        value =  value.slice(0, idx) + value.slice(idxEnd + Math.abs(0));
        return value;
	}
	window.getNewInputValueOnKeyDown = function (e) {
      let newValue = e.target.value;
      let valueArray = newValue.split('');
      const selectionLength = (e.target.selectionEnd - e.target.selectionStart);
      if (e.key === 'Backspace') {
        if (selectionLength === 0 && e.target.selectionStart > 0) {
          valueArray.splice(e.target.selectionStart - 1, selectionLength + 1);
        } else {
          valueArray.splice(e.target.selectionStart, selectionLength);
        }
      } else if (e.key === 'Delete') {
        if (selectionLength === 0) {
          valueArray.splice(e.target.selectionStart, selectionLength + 1);
        } else {
          valueArray.splice(e.target.selectionStart, selectionLength);
        }
      } else if (e.key === 'Enter') { 
        valueArray.splice(e.target.selectionStart, selectionLength, '\n');
      } else {
      	if (e.key.length == 1){ 
        	valueArray.splice(e.target.selectionStart, selectionLength, e.key);
        }
      }
      newValue = valueArray.join('');
      return newValue;
	}
	
	var baseLineDiv;
	var letter;
	
	//https://codepen.io/georgecrawford/pen/gbaJWJ
	window.getBaseLine = function(element) {
		/*<div class='container'>  
  			<span class="letter">Text aligyyned to baseline</span>
		</div>*/
		if (baseLineDiv == null) {
			baseLineDiv = document.createElement('div');
			baseLineDiv.style.position = 'absolute';
    		baseLineDiv.style.left="-999999px";
			baseLineDiv.setAttribute('class', 'container');
			letter = document.createElement('span');
			letter.setAttribute('class', 'letter');
			letter.innerHTML = "Text aligned to baseline";
			baseLineDiv.appendChild(letter);
			window.shadowRoot.appendChild(baseLineDiv);
		}
	
		
		letter.style.font = element.style.font;
    	letter.style.fontSize = element.style.fontSize;
    	letter.style.fontFamily = element.style.fontFamily;
    	var baseLine = letter.offsetTop + letter.offsetHeight - baseLineDiv.offsetHeight - baseLineDiv.offsetTop;
    	//console.log("baseLine " + letter.style.fontSize + " " + (letter.offsetHeight - baseLine));
    	return letter.offsetHeight - baseLine;
		
	};
	window.getImageAsBase64 = function(element) {
		const canvas = document.createElement('canvas');
		const ctx = canvas.getContext('2d');
	   	// Set width and height
	   	canvas.width = element.clientWidth;
	   	canvas.height = element.clientHeight;

	   	// Draw the image
	   	ctx.drawImage(element, 0, 0);
	   	return canvas.toDataURL('image/jpeg');	
	};
	window.isRTLLayout = function() {
		var userLang = navigator.language || navigator.userLanguage;
		// detemine if rtl or some other way 
		return false;
	}
	
	window.getScrollbarWidth = function() {
	  	// Creating invisible container
	  	const outer = document.createElement('div');
	  	outer.style.visibility = 'hidden';
	  	outer.style.overflow = 'scroll'; // forcing scrollbar to appear
	  	outer.style.msOverflowStyle = 'scrollbar'; // needed for WinJS apps
	  	document.body.appendChild(outer);
	
	  	// Creating inner element and placing it in the container
	  	const inner = document.createElement('div');
	  	outer.appendChild(inner);

  	  	// Calculating difference between container's full width and the child width
  	  	const scrollbarWidth = (outer.offsetWidth - inner.offsetWidth);

  		// Removing temporary elements from the DOM
  		outer.parentNode.removeChild(outer);

  		return scrollbarWidth;
	}