function ajaxRequest(method,url,params,callbackFunction){
	let xhr=new XMLHttpRequest();
	method = (method) ? method:'GET';
	method = (method!='GET'&& method!='POST')?'GET':method;
	params = (params)? params:null;
	url = (method=='GET'&& params!=null) ? url+"?"+params : url; 
	
	xhr.open(method,url,true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send((method=='POST')?param:null);
	xhr.onload=function(){
		callbackFunction(xhr);
	};
	
}