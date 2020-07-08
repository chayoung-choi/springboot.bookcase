var common = {
  pressEnterWithClickElement : function(btnId){
    if (event.keyCode == '13'){
      $("#" + btnId).click();
    }
  }
};