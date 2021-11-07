<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Bootstrap core CSS -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>
        <link rel="stylesheet" href="../nav/nav.css">
        <link rel="stylesheet" href="corporation.css">
        <title>corporation register</title>
    </head>

    <body>
        <?php require('../nav/nav.php'); ?>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 ">
            <div class="pt-3 pb-2 mb-3 border-bottom">
                <h3 style="text-align:left;">기업목록</h3>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="form-group col-5">
                        <div class="col-sm-5">
                            <div class="input-group">
                                <input type="text" class="form-control form-control-sm" id="corp_search">
                                <div class="input-group-append">
                                    <button class="btn btn-dark btn-sm" type="submit" id="">검색</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-check col-2">
                        <input class="form-check-input" type="checkbox" id="corp_available" value="option1">
                        <label class="form-check-label" for="corp_available">사용가능</label>
                    </div>
                    <div class="form-check col-2">
                        <input class="form-check-input" type="checkbox" id="corp_stop" value="option2">
                        <label class="form-check-label" for="corp_stop">정지</label>
                    </div>
                </div>
                <table class="table table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">No</th>
                            <th scope="col">기업명</th>
                            <th scope="col">연락처</th>
                            <th scope="col">대표자</th>
                            <th scope="col">등록일자</th>
                            <th scope="col">상태</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td scope="row">13</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>사용 가능</td>
                        </tr>
                        <tr>
                            <td>12</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>사용 가능</td>
                        </tr>
                        <tr>
                            <td>11</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>사용 가능</td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>사용 가능</td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>사용 가능</td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>정지</td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>정지</td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>정지</td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>정지</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>정지</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>정지</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>정지</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>달봉이</td>
                            <td>010-0000-0000</td>
                            <td>홍길동</td>
                            <td>2021-08-01</td>
                            <td>정지</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </main>
    </body>
</html>