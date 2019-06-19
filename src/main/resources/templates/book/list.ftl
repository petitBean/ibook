<html>
<head>
    <meta charset="UTF-8">
    <title>图书列表</title>

    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/ibook/css/search.css" rel="stylesheet">
    <link href="/ibook/css/ul.css" rel="stylesheet">

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
        <ul><li>IBOOK 首页</li></ul>
    </div>
</div>

<div id="menu" style="height: 100px;top: 100px;">
    <div class="siteIcon" style="float:  left;height:100px;width: 330px;background-color: ">
        <div style="float: left">
        <h2>welcome to </h2><h1>&nbsp&nbspIBOOK</h1>
        </div>
        <div id="icon" style="float: left;z-index: 0">
            <img src="http://127.0.0.1:8080/ibook/photo/kibooicon.png" style="height: 100px ;width: 160px">
        </div>
    </div>
    <div class="container" style="float: right ;margin: 50px 0px 0px 0px;width: 1000px">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active">
                                <a href="#">Link</a>
                            </li>
                            <li>
                                <a href="#">Link</a>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-left" role="search" action="/ibook/buyer/book/searchbybookname" method="post">
                            <div class="form-group">
                                <input type="text" name="bookName" class="form-control" />
                            </div> <button type="submit" class="btn btn-default">搜索</button>
                        </form>
                        <!--
                        <form action="/buyer/book/sesrch" class="navbar-form navbar-left parent" method="post">
                            <input type="text" class="search" placeholder="搜索">
                            <input type="button" name="bookName" id="" class="btn btn1 btn-default" >
                        </form>-->
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="/ibook/buyer/book/cart/ordermasterlist">我的订单</a>
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
                   <a href="/ibook/buyer/book/searchbycategory?categoryType=${category.categoryType}">&nbsp${category.categoryName}</a>
               </li>
           </#list></#if>
       </ul>
     </div>
    </div>
</div>

<div class="container2" style="float: right;width: 800px;margin: 0px 0px 0px 40px">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table" style="width: 600px;margin: 20px">
                <tbody>
                <#if bookList?? &&(bookList?size>0)>
                 <#list bookList as book>
                     <#if (book_index%4==0)>
                         <tr>
                     </#if>
                         <td style="height: 200px;width: 200px ;text-align: center; ">
                              <a href="/ibook/buyer/book/bookdetail?bookId=${book.bookId}" style="padding: 30px 30px 30px 30px;margin:10px 10px 10px 10px"><img height="150" width="150" src="${book.bookIcon}" alt="加载中..." ></a><br/>
                             <br style="text-align: center">
                               ${book.bookName}
                             <br>
                              <textarea style="border: none;width: 230px;height: 100px;font-family: 新宋体;font-size: 10px">简介： ${book.bookDescribe}</textarea><br>
                              <a style="color: red">￥ ${book.bookPrice} </a><br><br>
                          </td>
                     <#if (book_index%4==3)>
                         <tr>
                     </#if>
                 </#list></#if>
                </tbody>
            </table>
        </div>
    </div>
</div>

</div>
</body>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function getBuyerPhone() {
        var name="buyer_id"+"=";
        var buyerPhone = "";//返回值
        var cookies=document.cookie;
        var start=cookies.indexOf(name);
        if (start!=-1){
            start+=name.length;
            end = document.cookie.indexOf(";", start);
            alert(start);
            alert(end);
            if (end == -1)
                end = document.cookie.length;
            //unescape() 函数可对通过 escape() 编码的字符串进行解码。
            buyerPhone=unescape(document.cookie.substring(start, end));
            alert(buyerPhone);

        }
        return buyerPhone;
    }

</script>

</html>