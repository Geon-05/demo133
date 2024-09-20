const book_no = document.querySelector("#book_no").value;

function bookUpdate() {
  const btn_book_update = document.querySelector("#btn_book_update");

  btn_book_update.addEventListener("click", function () {
    location.href = `/book/bookUpdate?book_no=${book_no}`;
  });
}

function bookDelete() {
  const btn_book_delete = document.querySelector("#btn_book_delete");

  btn_book_delete.addEventListener("click", function () {
    location.href = `/book/bookDelete?book_no=${book_no}`;
  });
}

function go_book_list() {
  const go_book_list = document.querySelector("#go_book_list");

  go_book_list.addEventListener("click", function () {
    location.href = "/book/bookList";
  });
}

bookUpdate();
go_book_list();
bookDelete();