<?
    /*******************************************************************************
    ** 공통 변수, 상수, 코드
    *******************************************************************************/
    error_reporting( E_CORE_ERROR | E_CORE_WARNING | E_COMPILE_ERROR | E_ERROR | E_WARNING | E_PARSE | E_USER_ERROR | E_USER_WARNING );

    // 보안설정이나 프레임이 달라도 쿠키가 통하도록 설정
    header('P3P: CP="ALL CURa ADMa DEVa TAIa OUR BUS IND PHY ONL UNI PUR FIN COM NAV INT DEM CNT STA POL HEA PRE LOC OTC"');
    header("Content-Type:text/html;charset=utf-8");

    @ini_set("session.use_trans_sid", 0);	// PHPSESSID를 자동으로 넘기지 않음	=> session.auto_start = 0 으로 설정 / PHP 5 이상 버전부터 session.use_trans_sid 설정을 ini_set으로 바꿀 수 없음
    @ini_set("url_rewriter.tags","");			// 링크에 PHPSESSID가 따라다니는것을 무력화함


    //session_save_path("$_SERVER[DOCUMENT_ROOT]/adm/data/session");

    if (isset($SESSION_CACHE_LIMITER))
        @session_cache_limiter($SESSION_CACHE_LIMITER);
    else
        @session_cache_limiter("no-cache, must-revalidate");

    @ini_set("session.cache_expire", 1440);			// 세션 캐쉬 보관시간 (분)
    @ini_set("session.gc_maxlifetime", 86400);	// session data의 gabage collection 존재 기간을 지정 (초) 24시간후 로그인 상태 해제
    @ini_set("session.gc_probability", 1); // session.gc_probability는 session.gc_divisor와 연계하여 gc(쓰레기 수거) 루틴의 시작 확률을 관리합니다. 기본값은 1입니다. 자세한 내용은 session.gc_divisor를 참고하십시오.
    @ini_set("session.gc_divisor", 100); // session.gc_divisor는 session.gc_probability와 결합하여 각 세션 초기화 시에 gc(쓰레기 수거) 프로세스를 시작할 확률을 정의합니다. 확률은 gc_probability/gc_divisor를 사용하여 계산합니다. 즉, 1/100은 각 요청시에 GC 프로세스를 시작할 확률이 1%입니다. session.gc_divisor의 기본값은 100입니다.
    session_set_cookie_params(0, "/");
    @ini_set("session.cookie_domain", "");

    @session_start();

    $adminChk = $_SESSION['adminChk'];
?>