var bookcase = {
	init : function() {
		var _this = this;
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
