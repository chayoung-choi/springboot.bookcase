var bookcase = {
	init : function() {
		var _this = this;
		var current_hash = location.hash;
		var current_index = 0;
		var list = document.querySelectorAll(".nav-link[tabindex]");
		Array.prototype.forEach.call(list, function (item) {
		  if (item.hash == current_hash){
			  current_index = item.tabIndex;
		  }
		});
		
		document.querySelectorAll(".navbar-button > [data-tab-index='2']").forEach(function(el){
			el.style.display = block;
			document.querySelector("form.navbar-button").style.display= block;
			console.log(el);
		
		});
	},
	saveBookcase : () => {
		
		var data = {
			name : $("#name").val(),
			picture : $("#picture").val()
		};
		
		$.ajax({
			type : 'POST',
			data : JSON.stringify(data),
			url : '/api/v1/bookcase/save',
			contentType : 'application/json; charset=utf-8',
			dataType : 'text'
		}).done(function(result) {
			alert("등록되었습니다.");
			window.location.href = '/bookcase#bookcase';
		}).fail(function(error) {
			alert("등록에 실패하였습니다.");
			console.log(JSON.stringify(error));
		})
	}

};

bookcase.init();


$(document).ready(function () {
	

});
