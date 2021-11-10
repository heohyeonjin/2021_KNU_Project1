<?
	include_once $_서버루트.'/common/common.php';

	$userName = $_REQUEST[UserName];

	$query = "select ____ from _____ where ____ = ____ and ____ = ____";
	$conn ->


	if(결과가 없으면){
		알림을 띄우고 로그인 페이지로 이동

		$conn->popup_msg_location("아이디 비밀번호가 일치하지 않습니다.", "/로그인 파일이 있는 경로");
	}else{
		$conn->popup_msg_location("로그인에 성공했습니다.", "/로그인 완료 후 첫화면이 되어야 하는 파일 경로");
	}
?>