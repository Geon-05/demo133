function go(pageNo_input) {
  let pageNo = document.querySelector("#pageNo");
  let searchForm = document.querySelector("#searchForm");

  pageNo.value = pageNo_input;
  searchForm.submit();
}

function insertTestMember(){
  let btn_insertTestMember = document.querySelector('#btn_insertTestMember');

  btn_insertTestMember.addEventListener("click", function(){
    location.href = "/member/testMemberInsert";
  })
}


insertTestMember();