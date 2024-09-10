logout();

function go(pageNo_input) {
  let pageNo = document.querySelector("#pageNo");
  let searchForm = document.querySelector("#searchForm");

  pageNo.value = pageNo_input;
  searchForm.submit();
}

function logout() {
  let btn_logout = document.querySelector("#btn_logout");

  if (btn_logout) {
    btn_logout.addEventListener("click", function () {
      location.href = "/login/logout";
    });
  }
}
