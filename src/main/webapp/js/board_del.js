window.onload=function(){
	let myForm = document.getElementById('delete_form');
	myForm.onsubmit=function(){
		let passwd = document.getElementById('passwd');
		if(passwd.value.trim()==''){
			alert('비밀번호를 입력하세요!');
			passwd.value='';
			passwd.focus();
			return false;
		}
	};
};