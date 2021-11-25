function msgSend(roomNo){
    let msg = $('#input_message').val();
    let msgType = 1;
    $('#input_message').val("");
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

        },
        error: function(){
            alert("메세지 전송에 실패하였습니다.");
        }
    });
}