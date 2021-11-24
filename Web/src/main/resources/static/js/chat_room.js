function msgSend(roomNo){
    let msg = $('#input_message').val();
    let msgType = 1;

    $.ajax({
        url:'/counseling/' + roomNo + '/send',
        type:'post', //POST 방식으로 전달
        data:{
            msg:msg,
            msgType:msgType,
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