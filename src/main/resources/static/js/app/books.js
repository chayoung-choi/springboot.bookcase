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
			bindSearhBookList(result);
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
			success : function(data){
				alert("대여되었습니다.");
			}, 
			error : function(error){
				alert("도서 대여에 실패하였습니다.");
				console.log(JSON.stringify(error));
			}
		});
	}
};

books.init();

function bindSearhBookList(result){
	var list = JSON.parse(result).documents;
	searchBookList = list;
	document.querySelector('.search-book-list').innerHTML = '';
	var ul = document.querySelector('.search-book-list');
	var tempLi = document.querySelector('#temp_book_li').content;
	
	for (var i=0; i<list.length; i++){
		var li = tempLi.cloneNode(true);
		li.querySelector(".list-group-item").dataset.idx = i;
		li.querySelector(".img-thumbnail").src = list[i].thumbnail;
		li.querySelector(".book-title").textContent = list[i].title;
		li.querySelector(".book-authors").textContent = list[i].authors;
		li.querySelector(".book-publisher").textContent = list[i].publisher;
		li.querySelector(".book-publication-date").textContent = list[i].datetime;
		li.querySelector(".book-contents").textContent = list[i].contents;
		li.querySelector(".book-price").textContent = list[i].price;
		li.querySelector(".book-url").href = list[i].url;
		ul.appendChild(li);
	}
}