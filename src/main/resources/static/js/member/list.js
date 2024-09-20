function go(pageNo_input) {
  const pageNo = document.querySelector("#pageNo");
  const searchForm = document.querySelector("#searchForm");

  pageNo.value = pageNo_input;
  searchForm.submit();
}

function insertTestMember(){
  const btn_insertTestMember = document.querySelector('#btn_insertTestMember');

  btn_insertTestMember.addEventListener("click", function(){
    location.href = "/member/testMemberInsert";
  })
}


insertTestMember();