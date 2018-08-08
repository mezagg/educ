//get screen width
function getWidth(){
	var windowWidth = 0;
	if(typeof(window.innerWidth) == 'number'){
		windowWidth = window.innerWidth;
	}else if(document.documentElement && (document.documentElement.clientWidth || document.documentElement.clientHeight)){
		windowWidth = document.documentElement.clientWidth;
	}else if(document.body && (document.body.clientWidth || document.body.clientHeight)){
		windowWidth = document.body.clientWidth;
	}
	return windowWidth;
}

//get screen height
function getHeight(){
	windowHeight = 0;
	if(typeof(window.innerWidth) == 'number'){
		windowHeight = window.innerHeight;
	}else if(document.documentElement && (document.documentElement.clientWidth || document.documentElement.clientHeight)){
		windowHeight = document.documentElement.clientHeight;
	}else if(document.body && (document.body.clientWidth || document.body.clientHeight)){
		windowHeight = document.body.clientHeight;
	}
	return windowHeight;
}