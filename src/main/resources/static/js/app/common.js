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

var tab = {
	init : function() {
		var _this = this;
	},
	moveNavTab : () => {
		var target = event.target;
		if (target.closest('.nav-item') == null){
			return;
		}
		tab.toggleActiveTab(target);
		tab.slideSwiper(target);
	},
	toggleActiveTab : (target) => {
		var nav = target.closest('.nav');
		nav.querySelector('.nav-link.active').classList.remove('active');
		target.closest('.nav-link').classList.add('active');
	},
	slideSwiper : (target) => {
		var mySwiper = document.querySelector('.swiper-container').swiper;
		if (mySwiper == null){ return; }
		var tabIndex = target.closest('.nav-link').tabIndex - 1;
		mySwiper.slideTo(tabIndex);
	},
}


var swiper = {
	init : () => {
		
		if (document.querySelector('.swiper-container') == null){
			return;
		}
		
		var initHash = location.hash;
		var tabIndex = 0;
		
		if (initHash != ""){
			var target = document.querySelector('.nav-link[href="'+ initHash +'"]');
			tabIndex = target.tabIndex - 1;
			tab.toggleActiveTab(target);
		}
		
		var swiper = new Swiper('.swiper-container', {
		    speed: 400,
		    spaceBetween: 100,
		    initialSlide: tabIndex,
		    autoHeight: true,
		});
		
		swiper.on('slideChange', function () {
		  var tabIndex = swiper.activeIndex + 1;
		  var target = document.querySelector('.nav-link[tabindex="'+ tabIndex +'"]');
		  target.click();
		});
	}
}

common.init();

$(document).ready(function () {
	swiper.init();
});