
// 상단 navbar scroll에 숨김
var prevScrollpos = window.pageYOffset;
window.onscroll = function() {
  var currentScrollPos = window.pageYOffset;
    if (prevScrollpos > currentScrollPos) {
      document.getElementById("navbarTop").style.top = "0";
    } else {
      document.getElementById("navbarTop").style.top = "-5rem";
    }
  prevScrollpos = currentScrollPos;
}

var main = {
	init : function() {
		var _this = this;
		$('#btn-save').on('click', function() {
			_this.save();
		});

		$("#btn-update").on('click', function() {
			_this.update();
		});
		
		$("#btn-delete").on('click', function () {
           _this.delete();
	    });
	},
	save : function() {
		var data = {
			title : $("#title").val(),
			author : $("#author").val(),
			content : $("#content").val()
		};

		$.ajax({
			type : 'POST',
			url : '/api/v1/posts',
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(data)
		}).done(function() {
			alert('글이 등록되었습니다.');
			window.location.href = '/';
		}).fail(function(error) {
			alert(JSON.stringify(error));
		})
	},
	update : function() {
		var data = {
			title : $("#title").val(),
			content : $("#content").val()
		};

		var id = $("#id").val();

		$.ajax({
			type : 'PUT',
			url : '/api/v1/posts/' + id,
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(data)
		}).done(function() {
			alert('글이 수정되었습니다.');
			window.location.href = '/';
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	delete : function () {
       var id = $("#id").val();

       $.ajax({
           type : 'DELETE',
           url : '/api/v1/posts/'+ id,
           dataType : 'json',
           contentType : 'application/json; charset=utf-8'
       }).done(function () {
           alert('글이 삭제되었습니다.');
           window.location.href = '/';
       }).fail(function (error) {
           alert(JSON.stringify(error));
       });
   }
};

main.init();

function getUserMedia(options, successCallback, failureCallback) {
	  var api = navigator.getUserMedia || navigator.webkitGetUserMedia ||
	    navigator.mozGetUserMedia || navigator.msGetUserMedia;
	  if (api) {
	    return api.bind(navigator)(options, successCallback, failureCallback);
	  }
	}

	var theStream;

	function getStream() {
	  if (!navigator.getUserMedia && !navigator.webkitGetUserMedia &&
	    !navigator.mozGetUserMedia && !navigator.msGetUserMedia) {
	    alert('User Media API not supported.');
	    return;
	  }
	  
	  var constraints = {
	    video: true
	  };

	  getUserMedia(constraints, function (stream) {
	    var mediaControl = document.querySelector('video');
	    if ('srcObject' in mediaControl) {
	      mediaControl.srcObject = stream;
	    } else if (navigator.mozGetUserMedia) {
	      mediaControl.mozSrcObject = stream;
	    } else {
	      mediaControl.src = (window.URL || window.webkitURL).createObjectURL(stream);
	    }
	    theStream = stream;
	  }, function (err) {
	    alert('Error: ' + err);
	  });
	}

	function takePhoto() {
	  if (!('ImageCapture' in window)) {
	    alert('ImageCapture is not available');
	    return;
	  }
	  
	  if (!theStream) {
	    alert('Grab the video stream first!');
	    return;
	  }
	  
	  var theImageCapturer = new ImageCapture(theStream.getVideoTracks()[0]);

	  theImageCapturer.takePhoto()
	    .then(blob => {
	      var theImageTag = document.getElementById("imageTag");
	      theImageTag.src = URL.createObjectURL(blob);
	    })
	    .catch(err => alert('Error: ' + err));
	}