function msgSend(){
    var msg = $('#input_message').val();
    var msgType = "STRING";
    var sender = 1;
    var roomId = 1;

    $.ajax({
        url:'/counseling/send',
        type:'post', //POST 방식으로 전달
        data:{
            msg:msg,
            msgType:msgType,
            sender:sender,
            roomId:roomId
        },
        success: function(returnValue){
            if (returnValue) {
                console.log("메세지 전송 성공");
            } else {
                alert("error");
            }
            $('#input_message').val("");
        },
        error: function(){
            alert("서버 에러입니다");
        }
    });
}