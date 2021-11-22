let lastRoom = 0;

function checkLastRoom(){
    $.ajax({
        url: "/poll/room/lastRoom",
        type: "get",
        success: function(response) {
            if (response) {
                lastRoom = response;
                console.log("마지막 방 id: " + lastRoom);
            }
            addRoom();
        },
        error: function() {
            alert("서버 에러입니다.");
        }
    });
}

function addRoom(){

}