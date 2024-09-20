const book_no = document.querySelector("#book_no").value;

function go_book_list() {
  const go_book_list = document.querySelector("#go_book_list");
  
  go_book_list.addEventListener("click", function () {
    location.href = "/book/bookList";
  });
}

function update_book() {
  const btn_book_update = document.querySelector("#btn_book_update");

  btn_book_update.addEventListener("click", function () {
    updateForm.submit();
  });
}

update_book()
go_book_list();