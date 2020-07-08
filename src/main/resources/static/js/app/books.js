var books = {
	init : function() {
		var _this = this;
		// $('#btn-books-search').on('click', function() {
		// _this.search();
		// });
	},
	search : function() {
		$.ajax({
			type : 'GET',
			url : '/kakao/books',
			dataType : 'text',
			data : {
				title : $("#search-title").val()
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
	console.log("list", list);
	var ul = document.querySelector('.list-unstyled');
	
	for (var i=0; i<list.length; i++){
		var li = ul.querySelector('li').cloneNode(true);
		console.log(li);
		li.querySelector('.title').textContent = list.title;
		ul.appendChild(li);
	}
}