$(document).ready(function() {
    $('#input_message').on('input', function(){
        if ($('#input_message').val()==='')
            $('#input_send').attr("disabled", true);
        else
            $('#input_send').attr("disabled", false);
        });
});

function msgSend(){
    var msg = $('#input_message').val();
    var time = new Date();

    $.ajax({
        url:'/counseling/send',
        type:'post', //POST 방식으로 전달
        data:{ msg:msg, time:time },
        success: function(returnValue){
            if (returnValue) {
                alert(returnValue);
            } else {
                alert("error");
            }
        },
        error: function(){
            alert("서버 에러입니다");
        }
    });
}
