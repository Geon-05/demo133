function go(pageNo_input) {
  const pageNo = document.querySelector("#pageNo");
  const searchForm = document.querySelector("#searchForm");

  pageNo.value = pageNo_input;
  searchForm.submit();
}

function go_insert_book(){
  const btn_insert_book = document.querySelector('#btn_insert_book');

  btn_insert_book.addEventListener('click',function(){
    location.href='/book/bookInsert'
  })
}

go_insert_book();