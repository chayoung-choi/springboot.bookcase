var searchBookList;
var books = {
	init : function() {
		var _this = this;
	},
	search : function() {
		var val = $("#search-title").val();
		if (val.trim() == ""){
			return;
		}
		$.ajax({
			type : 'GET',
			url : '/kakao/books',
			dataType : 'text',
			data : {
				title : val 
			}
		}).done(function(result) {
			var data = new Object();
			data.list = JSON.parse(result).documents;
			console.log(data);
			renderSearchBookList(data);
		}).fail(function(error) {
			alert("도서 검색에 실패하였습니다.");
			console.log(JSON.stringify(error));
		})
	},
	rental : function() {
		var idx = event.target.closest('li').dataset.idx;
		var book = searchBookList[idx];
		console.log(book);
		$.ajax({
			type : 'POST',
			url : '/api/v1/book/rental',
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(book),
			error : function(error){
				alert("도서 대여에 실패하였습니다.");
				console.log(error);
			},
			success : function(response){
				alert("대여되었습니다.");
			} 
		});
	}
};

books.init();

function renderSearchBookList(data){
	fetch('/templates/books-template.html')
	.then((response) => response.text())
	.then((template) => {
		var rendered = Mustache.render($(template).filter('#books_search_result_template').html(), data);
		document.getElementById('books_search_result').innerHTML = rendered;    
    });
}