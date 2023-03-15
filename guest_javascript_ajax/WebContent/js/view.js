/**
 * 
 */
 export function render(templateId='#guest-main-template',jsonResult={},contentId='#content') {
	let templateHtml =document.querySelector(templateId).innerHTML;
	console.log(">>>>>templateHtml>>>>>"+templateHtml);
	let bindtemplate =Handlebars.compile(templateHtml);//탬플릿함수를 컴파일 해줌
	console.log(">>>>>bindtemplate>>>>>"+bindtemplate);
	let resultTemplate = bindtemplate(jsonResult);//resultTemplate 변수는 jsonResult 객체 또는 JSON 문자열에 대한 Handlebars.js 템플릿의 렌더링 결과를 포함하게 됩니다.
	console.log(">>>>>resultTemplate>>>>>"+resultTemplate);
	document.querySelector(contentId).innerHTML = resultTemplate;
}