let check_validation = true;

function check_password() {
  const input_pw = document.querySelector("#input_pw");
  const check_pw = document.querySelector("#check_pw");
  const info_pw = document.querySelector("#info_pw");

  check_pw.addEventListener("keyup", function () {
    if (input_pw.value != check_pw.value) {
      info_pw.innerHTML = "비밀번호가 다릅니다.";
      check_validation = false;
    } else if (input_pw.value == check_pw.value) {
      info_pw.innerHTML = "비밀번호 체크!";
      check_validation = true;
    }
  });
}

function fn_validation() {
  const input_id = document.querySelector("#input_id");
  const input_name = document.querySelector("#input_name");
  const input_pw = document.querySelector("#input_pw");
  const input_address = document.querySelector("#input_address");
  const input_phone = document.querySelector("#input_phone");
  const input_email = document.querySelector("#input_email");

  const regexp_pw = /^(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,12}$/;

  check_validation = true;

  if (input_id.value == "") {
    msgBoxInsert("아이디를 입력하세요.", "input_id");
    check_validation = false;
  } else {
    msgBoxDelete("input_id");
  }

  if (input_name.value == "") {
    msgBoxInsert("이름을 입력하세요.", "input_name");
    check_validation = false;
  } else {
    msgBoxDelete("input_name");
  }

  if (input_pw.value == "") {
    msgBoxInsert("비밀번호를 입력하세요.", "input_pw");
    check_validation = false;
  } else if (!regexp_pw.test(input_pw.value)) {
    msgBoxInsert(
      "비밀번호는 영문자, 숫자와 특수문자를 조합하여주세요 \n 8~12자리를 입력하세요.",
      "input_pw"
    );
    check_validation = false;
  } else {
    msgBoxDelete("input_pw");
  }

  if (input_email.value == "") {
    msgBoxInsert("이메일을 입력하세요.", "input_email");
    check_validation = false;
  } else {
    msgBoxDelete("input_email");
  }

  if (input_address.value == "" || input_phone.value == "") {
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
  if (check_validation) {
    alert("아이디가 등록됨 확인!");
    registerForm.submit();
  } else {
    alert("알수없는 오류가 발생하였습니다. \n 관리자에게 문의하세요.");
    return;
  }
}

function check_id() {
  const btn_checkId = document.querySelector("#btn_checkId");

  const regExp_id = /^[a-zA-Z0-9]{4,12}$/;

  btn_checkId.addEventListener("click", function () {
    const inputIdValue = document.querySelector("#input_id").value;

    if (input_id.value == "") {
      msgBoxInsert("아이디를 입력하세요.", "input_id");
    } else if (!regExp_id.test(inputIdValue)) {
      msgBoxInsert(
        "아이디는 영문자(대,소문자)와 숫자만 입력가능합니다.\n 4~12자리를 입력하세요.",
        "input_id"
      );
    } else {
      fetch(`/checkId/${inputIdValue}`)
        .then((res) => res.json())
        .then((data) => {
          if (data.id_res == "1") {
            msgBoxInsert("중복된 아이디입니다.", "input_id");
          } else {
            msgBoxInsert("사용가능한 아이디입니다.", "input_id");
          }
        });
    }
  });
}

function register() {
  const btn_register = document.querySelector("#btn_register");

  btn_register.addEventListener("click", function () {
    fn_validation();
  });
}

function msgBoxInsert(msgBox, msgId) {
  let existingMsg = document.querySelector(`#${msgId} + p`);
  if (existingMsg) {
    existingMsg.remove();
  }
  document
    .getElementById(msgId)
    .insertAdjacentHTML("afterend", `<p id='msgBox'>${msgBox}</p>`);
}

function msgBoxDelete(msgId) {
  let existingMsg = document.querySelector(`#${msgId} + p`);
  if (existingMsg) {
    existingMsg.remove();
  }
}

check_id();
check_password();
register();
