var tab = {
	init : () => {
		var _this = this;
	},
	
	moveNavTab : () => {
		var target = event.target;
		if (target.closest('.nav-item') == null){
			return;
		}
		tab.toggleActiveTab(target);
		swiper.slideSwiper(target);
	},
	
	toggleActiveTab : (target) => {
		var nav = target.closest('.nav');
		nav.querySelector('.nav-link.active').classList.remove('active');
		target.closest('.nav-link').classList.add('active');
	},
	
	toggleActiveNavBtn : (tabIndex) => {
		var list = document.querySelectorAll("form.navbar-button > a.btn");
		if (list.length < 1){ return; }
		
		var active = false;
		Array.prototype.forEach.call(list, function(item) {
			if (item.getAttribute("data-tab-index") == tabIndex){
				item.style.display = "block";
				active = true;
			} else {
				item.style.display = "none";
			}
			  currentIndex = item.tabIndex;
		});
		
		if (active){
			document.querySelector("form.navbar-button").style.display = "block";
		} else {
			document.querySelector("form.navbar-button").style.display = "none";
		}
	}

}


var swiper = {
	init : () => {
		if (document.querySelector('.swiper-container') == null){
			return;
		}
		
		var tabIndex = 1;
		var currentHash = location.hash;
		if (currentHash != ""){
			var target = document.querySelector('.nav-link[href="'+ currentHash +'"]');
			tabIndex = target.tabIndex;
			tab.toggleActiveTab(target);
		}
		tab.toggleActiveNavBtn(tabIndex);
		
		var swiper = new Swiper('.swiper-container', {
		    speed: 400,
		    spaceBetween: 100,
		    initialSlide: tabIndex-1,
		    autoHeight: true,
		});
		
		swiper.on('slideChange', function () {
			var tabIndex = swiper.activeIndex + 1;
			var target = document.querySelector('.nav-link[tabindex="'+ tabIndex +'"]');
			tab.toggleActiveNavBtn(tabIndex);
			target.click();
		});
	},
	slideSwiper : (target) => {
		var mySwiper = document.querySelector('.swiper-container').swiper;
		if (mySwiper == null){ return; }
		var tabIndex = target.closest('.nav-link').tabIndex - 1;
		mySwiper.slideTo(tabIndex);
	},
}

swiper.init();