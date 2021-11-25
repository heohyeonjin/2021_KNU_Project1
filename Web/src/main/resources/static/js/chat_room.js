let lastDate = 0;

// 채팅방 입장 시 존재하는 메세지 붙이기
function addMsg(msg) {

    let curDate = msg.date;
    let sender = msg.sender;

    // 날짜가 다를 경우
    if (lastDate !== curDate) {
        if (sender === 1) {
            let newDateOther = `<div class="hr-sect" id="date-area">${curDate}</div>
                                <div class="item">
                                    <div class="box">
                                        <p class="msg">${msg.content}</p>
                                        <span class="time">${msg.time}</span>
                                    </div>
                                </div>`;
            $('#messages').append(newDateOther);
        }
        else {
            let newDateMe = `<div class="hr-sect" id="date-area">${curDate}</div>
                                <div class="item mymsg">
                                    <div class="box">
                                        <p class="msg">${msg.content}</p>
                                        <span class="time">${msg.time}</span>
                                    </div>
                                </div>`;
            $('#messages').append(newDateMe);
        }
        lastDate = msg.date;
    }

    // 날짜가 같을 경우
    else {
        if (sender === 1) {
            let otherMsg = `<div class="item">
                            <div class="box">
                                <p class="msg">${msg.content}</p>
                                <span class="time">${msg.time}</span>
                            </div>
                        </div>`;
            $('#messages').append(otherMsg);
        }
        else {
            let meMsg = `<div class="item mymsg">
                            <div class="box">
                                <p class="msg">${msg.content}</p>
                                <span class="time">${msg.time}</span>
                            </div>
                        </div>`
            $('#messages').append(meMsg);
        }
    }
}

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
            alert("메세지 전송에 실패하였습니다.");
        }
    });
}