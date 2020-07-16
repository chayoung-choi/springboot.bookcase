var common = {
	pressEnterWithClickElement : function(btnId) {
		if (event.keyCode == '13') {
			$("#" + btnId).click();
		}
	},
	// fa-chevron-up/down 아이콘 toggle
	toggleChevronIcon : function() {
		var target = event.target.querySelector('.icon-chevron i');
		console.log(target);
		if (target.classList.contains('fa-chevron-down')) {
			target.classList.remove('fa-chevron-down');
			target.classList.add('fa-chevron-up');
		} else {
			target.classList.remove('fa-chevron-up');
			target.classList.add('fa-chevron-down');
		}
	}
};