let book_no = document.querySelector("#book_no").value;

document.addEventListener("DOMContentLoaded", function () {
  go_book_list();
});

function go_book_list() {
  let go_book_list = document.querySelector("#go_book_list");

  go_book_list.addEventListener("click", function () {
    location.href = "/book/bookList";
  });
}
