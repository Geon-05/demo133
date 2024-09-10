let mem_no = document.querySelector('#mem_no').value

document.addEventListener("DOMContentLoaded", function () {
  memberUpdate();
  go_member_list();
  memberDelete();
});

function memberUpdate() {
  let btn_member_update = document.querySelector("#btn_member_update");

  btn_member_update.addEventListener("click", function () {
    location.href = `/member/memberUpdate?mem_no=${mem_no}`;
  });
}

function memberDelete() {
  let btn_member_delete = document.querySelector("#btn_member_delete");

  btn_member_delete.addEventListener("click", function () {
    location.href = `/member/memberDelete?mem_no=${mem_no}`;
  });
}

function go_member_list() {
  let go_member_list = document.querySelector("#go_member_list");

  go_member_list.addEventListener("click", function () {
    location.href = "/member/memberList";
  });
}
