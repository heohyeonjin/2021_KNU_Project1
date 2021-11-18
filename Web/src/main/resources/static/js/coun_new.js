var idValidation = 0;
var pwValidation = 0;

function checkId(){
    var id = $('#coun_id').val();
    var buttonStatus = $('#id_validation').html();

    if (buttonStatus === "중복확인") {
        $.ajax({
            url:'/corporation/idCheck',
            type:'post', //POST 방식으로 전달
            data:{id : id},
            success: function(corpIdCheck){
                if (corpIdCheck) {
                    alert("존재하는 아이디입니다.");
                } else {
                    alert("사용 가능한 아이디입니다.");
                    $('#corp_id').attr("readonly", true);
                    $('#id_validation').html("변경");
                    idValidation = 1;
                }
            },
            error: function(){
                alert("서버 에러입니다");
            }
        });
    } else {
        $('#corp_id').removeAttr("readonly");
        $('#id_validation').html("중복확인");
        idValidation = 0;
    }

}