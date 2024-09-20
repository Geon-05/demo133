const mem_no = document.querySelector("#mem_no").value;

function memberUpdate() {
  const btn_member_update = document.querySelector("#btn_member_update");

  btn_member_update.addEventListener("click", function () {
    location.href = `/member/memberUpdate?mem_no=${mem_no}`;
  });
}

function memberDelete() {
  const btn_member_delete = document.querySelector("#btn_member_delete");

  btn_member_delete.addEventListener("click", function () {
    location.href = `/member/memberDelete?mem_no=${mem_no}`;
  });
}

function go_member_list() {
  const go_member_list = document.querySelector("#go_member_list");

  go_member_list.addEventListener("click", function () {
    location.href = "/member/memberList";
  });
}

memberUpdate();
go_member_list();
memberDelete();