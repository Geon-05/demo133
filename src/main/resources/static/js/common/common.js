logout();

function logout() {
  let btn_logout = document.querySelector("#btn_logout");

  if (btn_logout) {
    btn_logout.addEventListener("click", function () {
      location.href = "/login/logout";
    });
  }
}
