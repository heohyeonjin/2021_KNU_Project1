<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FastResponse</title>
    <link href="main.css" rel="stylesheet">
  </head>

  <body>
  <!-- Bootstrap core CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  
  <!-- Option 2: Separate Popper and Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>


  <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">빠른답변</a>
  <a class="logout nav-link px-4" href="#" style="color:white;">Logout</a> <!-- logout 페이지로 변환 -->
 
</header>

<div class="container-fluid"> <!-- 대시보드 -->
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-dark sidebar collapse">
    <img src="../resources/logo.png" alt="" width="210px">  
    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-0 text-muted">
          <span>관리</span>      
        </h6>
    <div class="position-sticky pt-3">
        <ul class="nav flex-column"> <!--nav-tabs -->
         <li class="nav-item mb-3">
            <a class="nav-link" aria-current="page" href="#"> <!-- active-->
            <img src="../resources/corporation.svg" alt="" width="25px">  
              기업관리
            </span>
            </a>
          </li>
          <li class="nav-item mb-3">
            <a class="nav-link" href="#">
            <img src="../resources/counselor.svg" alt="" width="25px">  
              상담원관리
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
            <img src="../resources/client.svg" alt="" width="25px">  
              고객관리
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">기업관리</h1>
      </div>
  
    </main>

  </body>
</html>
