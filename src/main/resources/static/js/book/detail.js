let book_no = document.querySelector('#book_no').value

document.addEventListener("DOMContentLoaded", function () {
  bookUpdate();
  go_book_list();
  bookDelete();
});

function bookUpdate() {
  let btn_book_update = document.querySelector("#btn_book_update");

  btn_book_update.addEventListener("click", function () {
    location.href = `/book/bookUpdate?book_no=${book_no}`;
  });
}

function bookDelete() {
  let btn_book_delete = document.querySelector("#btn_book_delete");

  btn_book_delete.addEventListener("click", function () {
    location.href = `/book/bookDelete?book_no=${book_no}`;
  });
}

function go_book_list() {
  let go_book_list = document.querySelector("#go_book_list");

  go_book_list.addEventListener("click", function () {
    location.href = "/book/bookList";
  });
}
