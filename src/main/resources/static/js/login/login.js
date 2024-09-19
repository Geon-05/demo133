let login = function () {
  let btn_login = document.querySelector("#btn_login");
  
  btn_login.addEventListener("click", function () {
    
    let input_id = document.querySelector("#input_id");
    let input_password = document.querySelector("#input_password");
    
    if (input_id.value == "") {
      alert("아이디를 입력하세요.");
      return;
    } else if (input_password.value == "") {
      alert("비밀번호를 입력하세요.");
      return;
    } else {
      form_login.submit();
    }
  });
};

let id_save = function(){
  let idSave = getCookie('cookie_id');
  if (idSave!=null){
    let id = document.querySelector('#input_id');
    id.value = idSave;
    let chkIdSave = document.querySelector('#chkIdSave');
    chkIdSave.checked = true;
  }
}

function getCookie(name) {
  const cookies = document.cookie.split("; ");
  for (let cookie of cookies) {
    const [cookieName, cookieValue] = cookie.split("=");
    if (cookieName === name) {
      return decodeURIComponent(cookieValue);
    }
  }
  return null;
}

login();
id_save();