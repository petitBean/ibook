<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBOOK 订单详情</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/ibook/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/ibook/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/ibook/assets/css/form-elements.css">
    <link rel="stylesheet" href="/ibook/assets/css/style.css">
    <link rel="stylesheet" href="/ibook/css/login.css">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="topBar" style="height: 40px;background-color: #cccccc">
    <div id="topBar3" style="float: left">
        <ul><li><div class="ibook_firstpage"><a href="/ibook/buyer/book/cart/ordermasterlist"><img href="/ibook/photo/kibooicon.png" style="height: 30px;width: 30px">订单列表</a></div> </li></ul>
    </div>
</div>
<div class="logintop">
    <div class="siteIcon" style="float:  left;height:100px;width: 1500px;background-color: white ">
        <div id="icon" style="float: left;z-index: 0">
            <img src="/ibook/photo/kibooicon.png" style="height: 100px ;width: 160px">
        </div>
        <div style="float: left;height: 40px;margin: 20px ">
            <h1 class="logonh" style="text-align: center">&nbsp&nbspIBOOK</h1>
        </div>
        <div style="float: left;height: 40px;text-align: center;margin: 30px">
            <h3>&nbsp订单详情</h3>
        </div>
    </div>
</div>
<div style="height: 100px;width: 1500px;float: left">
    <hr style="color: red">
</div>
<div class="container">
    <div class="row clearfix">
        <!--表格1-->
        <div class="col-md-4 column">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        订单ID
                    </th>
                    <th>
                        订单总金额
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${orderDTO.orderId}</td>
                    <td>${orderDTO.orderAmount}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <!--表格2，订单详情-->
        <div class="col-md-12 column">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        商品图片
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        价格
                    </th>
                    <th>
                        数量
                    </th>
                    <th>
                        总金额
                    </th>
                </tr>
                </thead>
                <tbody>
                <#list detailList as orderDetail>
                    <tr>
                        <td>
                            <img src="${orderDetail.bookIcon}" style="height: 50px;width:45px;">
                        </td>
                        <td>
                            ${orderDetail.bookName}
                        </td>
                        <td>
                            ${orderDetail.bookPrice}
                        </td>
                        <td>
                            ${orderDetail.bookQuantity}
                        </td>
                        <td>
                            ${orderDetail.bookQuantity*orderDetail.bookPrice}
                        </td>
                    </tr>
                </#list>

                </tbody>
            </table>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <#if orderDTO.getOrderStatus()==0>
                <a href="#?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-primary">完结订单</a>
                <a href="/ibook/buyer/order/cancel?orderId=${orderDTO.orderId}" type="button" class="btn btn-default btn-danger">取消订单</a>
            </#if>

        </div>
    </div>
</div>


</body>
</html>