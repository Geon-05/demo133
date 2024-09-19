function go(pageNo_input) {
  let pageNo = document.querySelector("#pageNo");
  let searchForm = document.querySelector("#searchForm");

  pageNo.value = pageNo_input;
  searchForm.submit();
}

function go_insert_book(){
  let btn_insert_book = document.querySelector('#btn_insert_book');

  btn_insert_book.addEventListener('click',function(){
    location.href='/book/bookInsert'
  })
}

go_insert_book();