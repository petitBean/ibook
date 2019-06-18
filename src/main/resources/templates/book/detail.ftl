<html>
<head>
    <meta charset="UTF-8">
    <title>图书详情</title>

    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/ibook/css/search.css" rel="stylesheet">
    <link href="/ibook/css/ul.css" rel="stylesheet">
    <link href="/ibook/css/detail.css" rel="stylesheet">


</head>

<body >

<div id="topBar" style="height: 40px;background-color: #cccccc">
    <div  id="topBar1" style="float: right">
        <ul>
            <li>
                <a href="/ibook/buyer/user/tologin">登录</a>
            </li>
            <li>
                <a href="#">注册</a>
            </li>
            <li>
                <a href="/ibook/buyer/user/logout">退出</a>
            </li>
        </ul>
    </div>
    <div id="topBar3" style="float: left">
        <ul><li>IBOOK </li></ul>
    </div>
</div>

<div id="menu" style="height: 100px;top: 100px;">
    <div class="siteIcon" style="float:  left;height:100px;width: 330px;background-color: ">
        <div style="float: left">
            <h2>welcome to </h2><h1>&nbsp&nbspIBOOK</h1>
        </div>
        <div id="icon" style="float: left;z-index: 0">
            <img src="/ibook/photo/kibooicon.png" style="height: 100px ;width: 160px">
        </div>
    </div>
    <div class="container" style="float: right ;margin: 50px 0px 0px 0px;width: 1000px">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span>
                            <span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active">
                                <a href="/ibook/buyer/book/list">首页</a>
                            </li>
                            <li>
                                <a href="#">Link</a>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-left" role="search" action="/ibook/buyer/book/searchbybookname" method="post">
                            <div class="form-group">
                                <input type="text" name="bookName" class="form-control" />
                            </div> <button type="submit" class="btn btn-default">搜索</button>
                        </form><!--
                        <form action="/buyer/book/sesrch" class="navbar-form navbar-left parent" method="post">
                            <input type="text" class="search" placeholder="搜索">
                            <input type="button" name="bookName" id="" class="btn btn1 btn-default" >
                        </form>-->
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="#">我的订单</a>
                            </li>
                            <li class="active">
                                <a href="/ibook/buyer/book/cart/showcart">我的购物车</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</div>


<!--导航-->
<div style="float: left">
    <div id="left" style="height: 1000px ;width: 250px; ;float: left;background-color: ">
        <div>
            <input type="text" value="图书分类" style="">
        </div>
        <div style="height: 900px ;width: 200px; ;float: left;background-color: darkred;margin: 0px 0px 0px 48px">
            <div id="outerUl" style="margin: 50px 0px 0px 0px">
                <ul>
                    <li >
                        <a href="/ibook/buyer/book/list">&nbsp全部类目</a>
                    </li>
                    <#if categoryList?? &&(categoryList?size>0)>
                    <#list categoryList as category>
                        <li >
                            <a href="#">&nbsp${category.categoryName}</a>
                        </li>
                    </#list></#if>
                </ul>
            </div>
        </div>
    </div>

    <div class="container2" style="float: right;width: 800px;margin: 0px 0px 0px 40px">

        <div id="bookdetailOut">
           <div id="pictureBox" >
               <img src="${book.bookIcon}"  style="height: 240px;width: 180px">
           </div>
           <div id="bookdetail">
               <div id="bookDetailUl">
                   <ul>
                       <li>
                           书名：${book.bookName}
                       </li>
                       <li>
                           作者：${book.bookAuthor}
                       </li>
                       <li>
                           出版社:${book.bookPress}
                       </li>
                       <li>
                           出版时间：${book.publicTime}
                       </li>
                       <li>
                           版次：${book.bookEdition}
                       </li>
                       <li>
                           库存：${book.bookStock}
                       </li>

                       <li>
                           简介：${book.bookDescribe}
                       </li>
                   </ul>
               </div>
           </div>
        </div>
        <div id="addmenu " style="width: 1000px ;height: 50px;padding: 0px 150px 0px 300px" >
            <form class="navbar-form navbar-left" role="search" action="/ibook/buyer/book/cart/addToCart" method="post" >
                <input type="button" id="increase" value="-" style="height: 50px ;width: 25px;border: none;background-color: #d9edf7">
                <input type="text" name="bookQuantity" id="bookNum" value="1" style="height: 50px ;width: 40px;border: none;background: white;text-align: center;color: red">
                <input type="button" id="increase" value="+" style="height: 50px ;width: 25px;border: none;background-color: #d9edf7">
                <input type="submit" class="addmenu_btn" id="toCart"  value="加入购物车" style=" height: 50px ;width: 150px;border:none;color: white;font-size: 20px; background: #d43f3a;padding: 10px">
                <input hidden type="text" name="bookId" value="${book.bookId}">
            </form>
        </div>
    </div>
</div>

</body>

</html>