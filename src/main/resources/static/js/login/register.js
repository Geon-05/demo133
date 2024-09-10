let checkId = false;
let checkPw = false;

check_id();
check_password();

function check_password() {
  let input_pw = document.querySelector("#input_pw");
  let pw_check = document.querySelector("#pw_check");
  let pw_info = document.querySelector("#pw_info");

  pw_check.addEventListener("keyup", function () {
    if (input_pw.value != pw_check.value) {
      pw_info.innerHTML = "비밀번호가 다릅니다.";
      checkPw = false;
    } else if (input_pw.value == pw_check.value) {
      pw_info.innerHTML = "비밀번호 체크!";
      checkPw = true;
    }
  });
}

function fn_validation() {
  let input_id = document.querySelector("#input_id");
  let input_name = document.querySelector("#input_name");
  let input_pw = document.querySelector("#input_pw");
  let input_address = document.querySelector("#input_address");
  let input_phone = document.querySelector("#input_phone");

  let regexp_pw = /^(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;

  if (input_id.value == "") {
    alert("아이디를 입력하세요.");
    return;
  } else if (input_name.value == "") {
    alert("이름을 입력하세요.");
    return;
  } else if (input_pw.value == "") {
    alert("비밀번호를 입력하세요.");
    return;
  } else if (input_address.value == "" || input_phone.value == "") {
    let res = false;
    if (input_address.value == "" && input_phone.value == "") {
      res = confirm("주소와 전화번호를 기입하지 않습니까?");
      if (res) {
        input_address.value = null;
        input_phone.value = null;
      }
    } else if (input_address.value == "") {
      res = confirm("주소를 기입하지 않습니까?");
      if (res) {
        input_address.value = null;
      }
    } else {
      res = confirm("전화번호를 기입하지 않습니까?");
      if (res) {
        input_phone.value = null;
      }
    }
    if (!res) {
      return;
    }
  }
  
  if (!regexp_pw.test(input_pw.value)) {
    alert(
      "비밀번호는 영문자, 숫자와 특수문자를 조합하여주세요 \n 8~12자리를 입력하세요."
    );
    return;
  } else if (checkId == true && checkPw == true) {
    alert("아이디가 등록됨 확인!");
    registerForm.submit();
  } else {
    alert("알수없는 오류가 발생하였습니다. \n 관리자에게 문의하세요.");
    return;
  }
}

function check_id() {
  let btn_checkId = document.querySelector("#btn_checkId");

  let regExp_id = /^[a-zA-Z0-9]{4,12}$/;

  btn_checkId.addEventListener("click", function () {
    let inputIdValue = document.querySelector("#input_id").value;

    if (inputIdValue == "") {
      alert("아이디를 입력해주세요.");
      return;
    } else if (!regExp_id.test(inputIdValue)) {
      alert(
        "아이디는 영문자(대,소문자)와 숫자만 입력가능합니다.\n 4~12자리를 입력하세요."
      );
    } else {
      fetch(`/checkId/${inputIdValue}`)
        .then((res) => res.json())
        .then((data) => {
          if (data.id_res == "1") {
            alert("중복된 아이디입니다.");
          } else {
            checkId = true;
            alert("사용가능한 아이디입니다.");
          }
        });
    }
  });
}
