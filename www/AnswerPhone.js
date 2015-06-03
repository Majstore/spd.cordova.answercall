var AnswerPhone = function(){};

AnswerPhone.prototype.callNumber = function(success, failure){
    cordova.exec(success, failure, "AnswerPhone", "answerPhone");
};

//Plug in to Cordova
cordova.addConstructor(function() {

    if (!window.Cordova) {
        window.Cordova = cordova;
    };

    if(!window.plugins) window.plugins = {};
    window.plugins.CallNumber = new CallNumber();
});
