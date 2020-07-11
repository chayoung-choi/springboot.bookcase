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
			console.log(result);
			bindSearhBookList(JSON.parse(result));
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})
	}
};

books.init();

function bindSearhBookList(result){
	var list = result.documents;
	document.querySelector('.search-book-list').innerHTML = '';
	var ul = document.querySelector('.search-book-list');
	var tempLi = document.querySelector('#temp_book_li').content;
	
	for (var i=0; i<list.length; i++){
		var li = tempLi.cloneNode(true);
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