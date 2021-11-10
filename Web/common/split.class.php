<?php
// class 시작
class Dbconn {

	var $Host = "localhost";
	var $Username = "아이디 입력";
	var $Userpasswd = "비밀번호 입력";
	var $Dbname = "아이디 입력";
	var $Target = array();

	function Connection() {
		$this -> connect = mysqli_connect($this -> Host , $this -> Username , $this -> Userpasswd, $this->Dbname);
		mysqli_query($this -> connect, "set name utf8");
		mysqli_set_charset($this -> connect, "utf8");
	}

	function Close() {
		mysqli_close($this -> connect);
	}

	function popup_msg($msg) {
		echo("
		<script>
		alert('$msg');
		history.go(-1);
		</script>
		");
		exit;
	}
	function popup_msg_close($msg) {
		echo("
		<script>
		alert('$msg')
		history.go(-1)
		window.close()
		</script>
		");
		exit;
	}

	function popup_msg_location($msg,$url) {
		echo("
		<script>
			alert('$msg');
		    location = '$url';
		</script>
		");
	}
	function popup_nomsg_location($url) {
		echo("
		<script>
		    location = '$url';
		</script>
		");
	}
	function popup_nomsg_reload($msg) {
		echo("
		<script>
		    opener.parent.location.reload();
			window.close();
		</script>
		");
	}
	function Dbtool($query) {
		$this->result = mysqli_query($this->connect,$query);
		//return $this -> result;
	}
	function NextRecord() {
		$this -> Row = mysqli_fetch_assoc($this -> result);
	}
	function ResultValue($FieldVal,$Su) {
		for($j = 0 ; $j < sizeof($FieldVal) ; $j++) {
			$this->{$FieldVal[$j]} = mysqli_result($this->result,$Su,$FieldVal[$j]);
			//return $this->{$FieldVal[$j]};
		}
	}
}

?>
