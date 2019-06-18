<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBOOK登陆页面</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/ibook/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/ibook/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/ibook/assets/css/form-elements.css">
    <link rel="stylesheet" href="/ibook/assets/css/style.css">
    <link rel="stylesheet" href="/ibook/css/login.css">

</head>

<body>

<!-- Top content -->
<div class="top-content">

  <div class="logintop">
      <div class="siteIcon" style="float:  left;height:100px;width: 1500px;background-color: white ">
          <div id="icon" style="float: left;z-index: 0">
              <img src="/ibook/photo/kibooicon.png" style="height: 100px ;width: 160px">
          </div>
          <div style="float: left;height: 40px;margin: 20px ">
              <h1 class="logonh" style="text-align: center">&nbsp&nbspIBOOK</h1>
          </div>
          <div style="float: left;height: 40px;text-align: center;margin: 20px">
             <h3>&nbsp欢迎登录</h3>
          </div>
      </div>
  </div>
    <div class="inner-bg" >
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">

                    <div class="form-bottom">
                        <form role="form" action="/ibook/buyer/user/login" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="buyerPhone" placeholder="Username..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">登录</button>

                        </form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <div class="social-login-buttons">
                        <a class="btn btn-link-2" href="#" style="color: red;font-size: 20px">
                             IBOOK首页
                        </a>
                        <a class="btn btn-link-2" href="#" style="color: red;font-size: 20px">
                           注 册
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>



</body>

</html>