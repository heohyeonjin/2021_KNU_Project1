<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel ="stylesheet" href="auth.css">
    <title>login</title>
</head>
<body>
    <div class="login">
        <div class="login_left">
            <br><br><br>
            <img src="../resources/logo.png" alt="" width="210px"> 
            <br><br><br>
            <h5><b>Welcome to Fast Response.</b></h5>
            <h5><b>This is Fast Response manager page.</b></h5>
        </div>
        <div class="login_right">
            <form>
              <br><br>
                <h2 style="text-align: center;"><b>SIGN IN</b></h2>
                <br><br>
                <div class="login_form">
                    <input class="form-control" name="UserName" type="text" placeholder="아이디">
                    <br>
                    <input class="form-control" name="PassWord" type="password" placeholder="비밀번호">
                    <br>
                    <div class="login_radio">
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
                          <label class="form-check-label" for="gridRadios1">
                            최고 관리자   
                          </label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
                          <label class="form-check-label" for="gridRadios2">
                            기업 관리자
                          </label>
                        </div>
                        <div class="form-check">
                          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3">
                          <label class="form-check-label" for="gridRadios3">
                            상담원
                          </label>
                        </div>
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary signIn-btn">로그인</button>
                </div>
                
              </form>
        </div>
    </div>
</body>
</html>