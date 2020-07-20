var bookcase = {
	init : function() {
		var _this = this;
	},

};

bookcase.init();


$(document).ready(function () {
	var swiper = new Swiper('.swiper-container', {
	    speed: 400,
	    spaceBetween: 100
	});
	
	swiper.on('slideChange', function () {
	  console.log('slide changed', swiper.activeIndex);
	  var tabIndex = swiper.activeIndex + 1;
	  var target = document.querySelector('.nav-link[tabindex="'+ tabIndex +'"]');
	  tab.toggleActiveTab(target);
	});
});
