var common = {
	init : function() {
		var _this = this;
		console.log("common init");
	},
	// input Enter시 buttn 동시 클릭 트리거 
	triggerForClickElement : function(btnId) {
		if (event.keyCode == '13') {
			$("#" + btnId).click();
		}
	},
	// layout nav tab click event toggle
	toggleNavTab : function(parentName, targetName){
		var target = event.target;
		if (target.closest(targetName) == null){
			return;
		}
		var navbar = target.closest(parentName);
		navbar.querySelector(targetName + '.active').classList.remove('active');
		target.closest(targetName).classList.add('active');
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
	},
	// 숫자 세자리씩 포맷 
	numberCommaFormat : (n) => {
		return n.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	} 
};

common.init();