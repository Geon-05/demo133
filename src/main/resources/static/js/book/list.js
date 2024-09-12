function go(pageNo_input) {
  let pageNo = document.querySelector("#pageNo");
  let searchForm = document.querySelector("#searchForm");

  pageNo.value = pageNo_input;
  searchForm.submit();
}