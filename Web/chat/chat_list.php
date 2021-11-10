<!DOCTYPE html>
<!-- Description: Kakao PC ver. Clone -->
<html lang="ko" data-dark="false">
    <head>
        <meta charset="utf-=8">
        <title>Counseling List</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <link rel="stylesheet" href="chat_list.css?after">
    </head>
    <body>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  
         <!-- Option 2: Separate Popper and Bootstrap JS -->
         <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        
         <!-- <script> var check = $("input[type='checkbox']");
                    check.click(function(){
	                $("p").toggle(); });
            </script> -->

        <header class ="p-1 bg-dark text-white sticky-top">
                 <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/logo.png"style="width:80px" href="#" alt=""></img>
                    <h5 class="head mb-1 mx-3 my-1 flex-fill">
                        <div class="my-1"style="color:gray;font-size:15px">상담원</div>
                        <div class="counseler-name mt-1">허현진</div>
                    </h5>
                    <div>
                        <label class="switch">
                            <input type="checkbox">
                            <span class="slider round"></span>
                        </label><br>
                        <div class="mt-2">
                            <a class="logout" href="#" style="color:#EEB500; font-size:15px;">로그아웃</a>
                        </div>
                    </div>
                </div>  
        </header>


    <div class=counseling-list>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="client-name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        <div class="list-group">
            <a href="#" class="list-group-item" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <img src="../resources/person.svg" style="width:50px" href="#" alt=""></img>
                    <h5 class="text mb-1 mx-3 flex-fill">
                        <div class="name my-1"style="font-weight:bold"> 홍길동</div>
                        <div class="last-comment">사이즈 문의드립니다.</div>
                    </h5>
                    <small>오후 5:24</small>
                 </div>
            </a>
        </div>
        
     </div>   
                   
           
</body>
</html>