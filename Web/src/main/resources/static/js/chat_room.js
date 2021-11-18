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
                alert("성공");
                let myMsg= "하이";
                let myTime="오전 10:05"
                let myChat = `<div class="item mymsg">
                                <div class="box">
                                    <p class="msg">${myMsg}</p>
                                    <span class="time">${myTime}</span>
                                </div>
                            </div>`
                $('#messages').append(myChat);
            } else {
                alert("error");
            }
        },
        error: function(){
            alert("서버 에러입니다");
        }
    });
}