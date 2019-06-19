<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBOOK 订单</title>
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
        <ul><li><div class="ibook_firstpage"><a href="/ibook/buyer/book/list"><img href="/ibook/photo/kibooicon.png" style="height: 30px;width: 30px">IBOOK首页</a></div> </li></ul>
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
            <h3>&nbsp订单列表</h3>
        </div>
    </div>
</div>

<div class="container" style="float: left;background-color:whitesmoke ;width: 1500;height: 1200px">
    <div class="row clearfix" style="margin: 50px 0px 0px 70px ;float: left;background-color: white">
        <div class="col-md-12 column">
            <#if orderDTOList?? &&(orderDTOList?size>0)>
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>订单id</th>
                    <th>姓名</th>
                    <th>手机号</th>
                    <th>地址</th>
                    <th>金额</th>
                    <th>订单状态</th>
                    <th>支付状态</th>
                    <th>创建时间</th>
                    <th colspan="2">操作</th>
                </thead>
                <tbody>
                <#list orderDTOList as orderDTO>
                    <tr>
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.buyerName}</td>
                        <td>${orderDTO.buyerPhone}</td>
                        <td>${orderDTO.buyerAddress}</td>
                        <td>${orderDTO.orderAmount}</td>
                        <td>${orderDTO.getOrderStatus()}</td>
                        <td>
                            <#if orderDTO.getPayStatus()==0>
                                <a href="#" style="color: red">去支付</a>
                            <#else>
                                <a href="#">已支付</a>
                            </#if>
                        </td>
                        <td>${orderDTO.createTime}</td>
                        <td>
                            <a href="/ibook/buyer/book/cart/detail?orderId=${orderDTO.orderId}">详情</a>
                        </td>

                        <td>
                            <#if orderDTO.getOrderStatus()==2>
                                <a href="#" style="color: red">已取消</a>
                            <#else>
                                <a href="/ibook/buyer/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                            </#if>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
            </#if>
        </div>
    </div>

</div>



</body>
</html>
