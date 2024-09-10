insert_book();

function insert_book() {
  let btn_addBook = document.querySelector("#btn_addBook");

  btn_addBook.addEventListener("click", function () {
    if (validation()) {
      insertForm.submit();
    }
  });
}

function validation() {
  let input_title = document.querySelector("#input_title");
  let input_author = document.querySelector("#input_author");
  let input_price = document.querySelector("#input_price");
  let input_public = document.querySelector("#input_public");
  let input_file = document.querySelector("#input_file");

  let validation_chk = true;
  let validation_pub_chk = true;
  let validation_file_chk = true;

  let extensions = ["jpg", "gif", "png"];
  const maxSize = 1024 * 1024 * 5;

  if (input_title.value == "") {
    msgBoxInsert("도서 타이틀을 입력하세요.", "input_title");
    validation_chk = false;
  } else {
    msgBoxDelete("input_title");
  }

  if (input_author.value == "") {
    msgBoxInsert("작가명을 입력하세요.", "input_author");
    validation_chk = false;
  } else {
    msgBoxDelete("input_author");
  }

  if (input_price.value == "") {
    msgBoxInsert("도서 금액 입력하세요.", "input_price");
    validation_chk = false;
  } else {
    msgBoxDelete("input_price");
  }

  if (input_public.value == "") {
    let res = confirm("출판사를 미기입합니까?");
    if (res) {
      validation_pub_chk = true;
    } else {
      validation_pub_chk = false;
    }
  }

  if (input_file.files.length == 0) {
    let res = confirm("파일첨부를 하지 않습니까?");
    if (res) {
      validation_file_chk = true;
    } else {
      validation_file_chk = false;
    }
  } else {
    for (let i = 0; i < input_file.files.length; i++) {
      if (!extensions.includes(input_file.files[i].name.split(".").pop())) {
        alert("파일의 확장자를 확인하세요.");
        validation_file_chk = false;
      } else if (input_file.files[i].size > maxSize) {
        alert("파일의 사이즈가 5MB이하인지 확인하세요.");
        validation_file_chk = false;
      }
    }
  }

  if (
    validation_chk == true &&
    validation_pub_chk == true &&
    validation_file_chk == true
  ) {
    return true;
  } else {
    return false;
  }
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
