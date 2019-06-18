<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBOOK</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/ibook/assets/css/style.css">
    <link rel="stylesheet" href="/ibook/css/login.css">
    <link rel="stylesheet" href="/ibook/css/seller/createbook.css">

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
                <h3>&nbsp商品管理</h3>
            </div>
        </div>
    </div>
   <div class="createbook_container">
       <div class="createbook_form_container">
           <div class="row clearfix">
               <div class="col-md-12 column">
                   <form  enctype="multipart/form-data" method="post" action="/ibook/seller/book/save">
                       <div class="form-group">
                           <label > 书  名 </label>
                           <input class="form-control createbook_form_input" type="text" name="bookName">
                       </div>
                       <div class="form-group">
                           <label > 单  价 </label>
                           <input class="form-control createbook_form_input" type="text" name="bookPriceText">
                       </div>
                       <div class="form-group">
                           <label >出版社</label>
                           <input  class="form-control createbook_form_input" type="text" name="bookPress">
                       </div>
                       <div class="form-group">
                           <label >版 本</label>
                           <input  class="form-control createbook_form_input" type="text" name="bookEdition">
                       </div>
                       <div class="form-group">
                           <label >出版时间</label>
                           <input  class="form-control createbook_form_input" type="text" name="publicTime">
                       </div>
                       <div class="form-group">
                           <label >类 目</label>
                           <input  class="form-control createbook_form_input" type="text" name="bookCategory">
                       </div>
                       <div class="form-group">
                           <label >作 者</label>
                           <input class="form-control createbook_form_input"  type="text" name="bookAuthor">
                       </div>
                       <div class="form-group">
                           <label >库 存</label>
                           <input class="form-control createbook_form_input"  type="number" name="bookStock">
                       </div>
                       <div class="form-group">
                           <label >简 介</label>
                           <input id="createbook_form_input_describe" class="form-control createbook_form_input"  type="text" name="bookDescribe">
                       </div>
                       <div class="form-group">
                           <label >图 片</label>
                           <input class=" form-control createbook_form_input"  type="file" name="bookIcon">
                       </div>
                       <#--隐藏字段-->
                       <input hidden name="sellerId" value="1559924464438959779">
                       <button type="submit" class="createbook_form_btn btn btn-default">提交</button>
                   </form>
               </div>
           </div>

       </div>
   </div>

</div>



</body>

</html>