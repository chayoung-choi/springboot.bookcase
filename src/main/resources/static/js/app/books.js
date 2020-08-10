var searchBookList = [];
var books = {
	init : function() {
		var _this = this;
	},
	kakaoSearch : function() {
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
			console.log(JSON.parse(result));
			renderSearchBookList(JSON.parse(result).documents);
		}).fail(function(error) {
			alert("도서 검색에 실패하였습니다.");
			console.log(JSON.stringify(error));
		})
	},
	rentalSearch : function() {
		var val = $("#search-title").val();
		if (val.trim() == ""){
			return;
		}
		$.ajax({
			type : 'GET',
			url : '/api/v1/book/rental-search/' + val,
			dataType : 'text'
		}).done(function(result) {
			console.log(JSON.parse(result));
		}).fail(function(error) {
			alert("도서 검색에 실패하였습니다.");
			console.log(JSON.stringify(error));
		})
	},
	
	register : function(){
		var idx = event.target.closest('.card').dataset.idx;
		var book = searchBookList[idx];
		
		$.ajax({
			type : 'POST',
			url : '/api/v1/book/register',
			data : JSON.stringify(book),
			contentType : 'application/json; charset=utf-8',
			dataType : 'text'
		}).done(function() {
			alert("등록되었습니다.");
		}).fail(function(error) {
			alert("죄송합니다. 등록에 실패하였습니다.");
			console.log(JSON.stringify(error));
		});
	},
	
	rental : function() {
		var idx = event.target.closest('li').dataset.idx;
		var book = searchBookList[idx];
		$.ajax({
			type : 'POST',
			url : '/api/v1/book/rental',
			data : JSON.stringify(book),
			contentType : 'application/json; charset=utf-8',
			dataType : 'text'
		}).done(function() {
			alert("대여되었습니다.");
			window.location.reload();
		}).fail(function(error) {
			alert("도서 검색에 실패하였습니다.");
			console.log(JSON.stringify(error));
		});
	}
};

books.init();

function renderSearchBookList(data){
	fetch('/templates/books-template.html')
	.then((response) => response.text())
	.then((template) => {
		
		var listIndex = searchBookList.length;
		Array.from(data, function(book){
			book.index = listIndex++;
			book.priceFormat = common.numberCommaFormat(book.price);
			book.datetimeFormat = moment(book.datetime).format('YYYY-MM-DD');
			searchBookList.push(book);
		});
		
		console.log(searchBookList);
		var rendered = Mustache.render($(template).filter('#books-search-result-template').html(), data);
		document.getElementById('books-search-result').innerHTML = rendered;    
    });
}