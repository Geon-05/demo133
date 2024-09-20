const mem_no = document.querySelector("#mem_no").value;

function go_member_list() {
  const go_member_list = document.querySelector("#go_member_list");

  go_member_list.addEventListener("click", function () {
    location.href = "/member/memberList";
  });
}

function update_member() {
  const btn_member_update = document.querySelector("#btn_member_update");

  btn_member_update.addEventListener("click", function () {
    updateForm.submit();
  });
}

update_member();
go_member_list();
