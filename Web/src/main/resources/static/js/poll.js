//방에 들어갈 때 Id, roomId값 받아오기

let lastMsg = 0;

function checkLast(){
    $.ajax({
        url: "/poll/lastMsg",
        type: "get",
        success: function(response) {
            if (response) {
                lastMsg = response;
            }
            addMessage();
        },
        error: function() {
            alert("서버 에러입니다.");
        }
    });
}

function addMessage() {
    $.ajax({
        url: "/poll",
        type: 'get',
        data: { lastMsg:lastMsg },
        timeout:60000,
        success: function(response){
            if (response) {
                for (let i=0; i<response.length; i++) {
                    console.log(response);
                    let myMsg = response[i]['content'];
                    let myTime= response[i]['time'];
                    let myChat = `<div class="item mymsg">
                                    <div class="box">
                                        <p class="msg">${myMsg}</p>
                                        <span class="time">${myTime}</span>
                                    </div>
                                </div>`
                    $('#messages').append(myChat);
                    console.log("뭐지: " + lastMsg);
                }
                lastMsg = response[response.length-1]['no'];
                console.log("polling 후: " + lastMsg);

            }
            setTimeout(addMessage(),10);
        },
        error: function(){
            alert("서버 에러입니다");
        }
    });
}



