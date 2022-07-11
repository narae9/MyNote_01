window.onload=function(){
	let myForm = document.getElementById('register_form');
	//이벤트 연결
	myForm.onsubmit=function(){
		let title = document.getElementById('title');
		if(title.value.trim()==''){
			alert('제목을 입력하세요!');
			title.value = '';
			title.focus();
			return false;
		}
		
		let name = document.getElementById('name');
		if(name.value.trim()==''){
			alert('이름을 입력하세요!');
			name.value = '';
			name.focus();
			return false;
		}
		
		let passwd = document.getElementById('passwd');
		if(passwd.value.trim()==''){
			alert('비밀번호를 입력하세요!');
			passwd.value = '';
			passwd.focus();
			return false;
		}
		
		let email = document.getElementById('email');
		if(email.value.trim()==''){
			alert('이메일을 입력하세요!');
			email.value = '';
			email.focus();
			return false;
		}
		
		let content = document.getElementById('content');
		if(content.value.trim()==''){
			alert('내용을 입력하세요!');
			content.value = '';
			content.focus();
			return false;
		}
		
	};
};



