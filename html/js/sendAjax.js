/* ajax 请求更新数据 */
function sendAjax(page, size, url) {
    var type = url.split("/")[1];
    var type2 = url.split("/")[2];
    console.log("查看的类型： " + type);
    url = url + "?page=" + page + "&pageSize=" + size;
    console.log(url);
    $.ajax({
        url: url,
        type: 'GET',
        cache: false,
        dataType: 'json',
        success: function (res) {
            var data = res.data.list;
            if (data) {
                if (type === "book") {
                    viewBookList(data)
                } else if (type === "cart") {
                    viewCartList(data)
                } else if (type === "order") {
                    if (type2 === "customer") {
                        viewCustomerOrderList(data)
                    } else {
                        //显示 订单明细
                        viewOrderDetail(data)
                    }

                }
            }
        }
    });
}

/**
 * 动态写入 书本列表信息
 * @param data
 */
function viewBookList(data) {

    var html = [];
    html += '<table style="height: 240px;width: 75%" cellpadding=3 cellspacing=1 align=center class=tableborder1 id="book-list">\n' +
        '    <tr>\n' +
        '        <td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>序号</b></font></td>\n' +
        '        <td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>产品名称</b></font></td>\n' +
        '        <td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>价格</b></font></td>\n' +
        '        <td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font></td>\n' +
        '    </tr>';
    for (var i = 0; i < data.length; i++) {
        html += '\n' +
            '    <tr>\n' +
            '        <td class=tablebody2 valign=middle align=center width="">' + (i + 1) + '</td>';
        html += ' <td class=tablebody1 valign=middle width=""> <a href="productDetail.html?' + data[i].id + '">' + data[i].name + '</a> </td>';
        html += '   <td class=tablebody2 valign=middle align=center width="">' + data[i].price + '</td>';
        html += ' <td class=tablebody1 valign=middle align=center width="">';
        html += '<a href="javascript:void(0);" onclick="add2Cart(' + data[i].id +
            ')"> ';
        html += '        <img border="0" src="images/car_new.gif" width="97" height="18">\n' +
            '        </a>\n' +
            '        </td>' +
            '</tr>';
    }
    html += "</table>";
    $('#show-book-list').html(html);
}


function viewCartList(data) {
    $("#cart-list-table").empty();
    if (data.length < 1) {
        $("#cart-list-table").html("<h3 style='color: red' align='center'>空空如也</h3>");
        return;
    }
    var html = [];
    var cost = 0;
    html += '        <table   cellpadding=3 cellspacing=1 align=center class=tableborder1>\n' +
        '            <tr>\n' +
        '                <td valign=middle align=center height=25 background="images/bg2.gif" width=""><font\n' +
        '                        color="#ffffff"><b>序号</b></font></td>\n' +
        '                <td valign=middle align=center height=25 background="images/bg2.gif" width="">\n' +
        '                    <font color="#ffffff"><b>产品名称</b></font>\n' +
        '                </td>\n' +
        '                <td valign=middle align=center height=25 background="images/bg2.gif" width=""><font\n' +
        '                        color="#ffffff"><b>价格</b></font></td>\n' +
        '                <td valign=middle align=center height=25 background="images/bg2.gif" width=""><font\n' +
        '                        color="#ffffff"><b>数量</b></font></td>\n' +
        '                <td valign=middle align=center height=25 background="images/bg2.gif" width=""><font\n' +
        '                        color="#ffffff"><b>合计</b></font></td>\n' +
        '                <td valign=middle align=center height=25 background="images/bg2.gif" width=""><font\n' +
        '                        color="#ffffff"><b>操作</b></font></td>\n' +
        '            </tr>';
    for (var i = 0; i < data.length; i++) {

        html += '         <tr id="cart-detail">\n' +
            '    \n' +
            '                <td class=tablebody2 valign=middle align=center width="">' + (i + 1) + '\n' +
            '                </td>\n' +
            '                <td class=tablebody1 valign=middle width="">\n' +
            '                    &nbsp;&nbsp;<a href="productDetail.html?' + data[i].id + '">' + data[i].book.name + '</a>\n' +
            '                </td>\n' +
            '                <td class=tablebody2 valign=middle align=center width="">' + data[i].book.price + '</td>\n' +
            '                <td class=tablebody1 valign=middle align=center width="">\n' +
            '                    <input type="text" name="number" value="' + data[i].num + '" size="4" id="cart_' + data[i].book.id + '"\n' +
            '                           onblur="javascript:if(this.value<1){this.value=1; }updateCart(this.id.toString()+\'_\'+this.value);"/>\n' +
            '                </td>\n' +
            '                <td class=tablebody2 valign=middle align=left>\n' +
            '                    &nbsp;&nbsp;￥<b>' + (data[i].book.price * data[i].num) + '</b>\n' +
            '                </td>\n' +
            '                <td class=tablebody1 valign=middle align=center>\n' +
            '                    <input id="cart_' + data[i].id + '" type="button" value="删除" onclick="deleteCart(this.id.toString().split(\'_\')[1])">\n' +
            '                </td>\n' +
            '    \n' +
            '            </tr>';
        cost += (data[i].book.price * data[i].num);
    }

    html += '            <tr>\n' +
        '                <td class=tablebody1 valign=middle align=center colspan="4">　</td>\n' +
        '                <td class=tablebody1 valign=middle align=left width="">&nbsp;&nbsp;<font color="#ff0000">\n' +
        '                    <!-------------------------总计 ------------------->\n' +
        '                    <b> ' + cost + '</b>\n' +
        '                </font>\n' +
        '                </td>\n' +
        '                <td class=tablebody1 valign=middle align=center width="">　</td>\n' +
        '            </tr>\n' +
        '    \n' +
        '            <tr>\n' +
        '                <td class=tablebody2 valign=middle align=center colspan="6"><input type="button" value="提交订单"\n' +
        '                                                                                   onclick="javascript:window.location=\'user/confirmOrder.html\';">\n' +
        '                    <input type="button" value="继续购物" onclick="javascript:window.location=\'/index.html\';">\n' +
        '                    <input type="button" value="清空购物车" onclick="clearCart()">\n' +
        '                </td>\n' +
        '            </tr>\n' +
        '        </table>';

    $("#cart-list-table").html(html)

}


/**
 * 查看用户的订单
 * @param list
 */

function viewCustomerOrderList(list) {


    $("#customer-order-list").empty();
    if (list.length === 0) {
        $("#customer-order-list").html("<h3 style='color: red' align='center'>空空如也</h3>");
        return;
    }

    var html = [];
    html += '    <table  cellpadding=3 cellspacing=1 align=center class=tableborder1 >\n' +
        '        <tr>\n' +
        '            <td valign=middle align=center height=25 background="../images/bg2.gif" width="">\n' +
        '                <font color="#ffffff"><b>序号</b></font>\n' +
        '            </td>\n' +
        '            <td valign=middle align=center height=25 background="../images/bg2.gif" width=""><font\n' +
        '                    color="#ffffff"><b>订单编号</b></font></td>\n' +
        '            <td valign=middle align=center height=25 background="../images/bg2.gif" width=""><font\n' +
        '                    color="#ffffff"><b>订单金额</b></font></td>\n' +
        '            <td valign=middle align=center height=25 background="../images/bg2.gif" width=""><font\n' +
        '                    color="#ffffff"><b>订单状态</b></font></td>\n' +
        '            <td valign=middle align=center height=25 background="../images/bg2.gif" width=""><font\n' +
        '                    color="#ffffff"><b>付款方式</b></font></td>\n' +
        '            <td valign=middle align=center height=25 background="../images/bg2.gif" width=""><font color="#ffffff"><b>操作</b></font>\n' +
        '            </td>' +
        '</tr>';
    for (var i = 0; i < list.length; i++) {
        html += ' <tr>\n' +
            '            <td class=tablebody2 valign=middle align=center width="">' + (i + 1) + '</td>\n' +
            '            <td class=tablebody1 valign=middle width="">&nbsp;&nbsp;\n' +
            '                <a href="orderinfo.html?' + list[i].id + '">' + list[i].id + '</a>\n' +
            '            </td>\n' +
            '            <td class=tablebody2 valign=middle align=left width="">&nbsp;&nbsp;￥' + list[i].cost + '</td>\n' +
            '            <td class=tablebody1 valign=middle align=center width="">' + list[i].state + '</td>\n';

        if (list[i].payway == null) {
            html += ' <td class=tablebody2 valign=middle align=left width="">&nbsp;待支付</td>\n';
        } else {
            html += '  <td class=tablebody2 valign=middle align=left width="">&nbsp;' + list[i].payway + '</td>\n';
        }

        html +=
            '            <td class=tablebody1 valign=middle align=center width="200px">\n' +
            '                <button  onclick="deleteOrder(' + list[i].id + ')">删除</button>&nbsp;' +
            '                <button  onclick="javascript:window.location=\'orderinfo.html?' + list[i].id + '\'">查看</button>&nbsp;';

        if (list[i].state === "pending") {
            html += '<button onclick="javascript:window.location=\'/order/' + list[i].id + '/payPage\'">去支付</button>';
        }

        html += '</td> ' +
            '</tr>';

    }
    html += '</table>';
    $("#customer-order-list").html(html);

}


function viewOrderDetail(list) {

    $("#view-order-detail").empty();
    if (list.length === 0) {
        $("#view-order-detail").html("<h3 style='color: red' align='center'>空空如也</h3>");
        return;
    }

    var html = [];
    html += '\n' +
        '        <table cellpadding="3" cellspacing="1" align="center" class="tableborder1">\n' +
        '            <tr>\n' +
        '                <td valign="middle" colspan="2" align="center" height="25" background="../images/bg2.gif">\n' +
        '                    <font color="#FFFFFF"><b>付款方式</b></font></td>\n' +
        '            </tr>\n' +
        '            <tr>\n' +
        '                <td width="40%" class="tablebody2" align="right">　</td>\n' +
        '                <td width="60%" class="tablebody1">\n';
    if (list[0].order.payway == null) {

        html += "<b>待支付</b>"
    }
    else {
        html += "<b>" + list[0].order.payway + " </b>"
    }


    html +=
        '                </td>\n' +
        '            </tr>\n' +
        '        </table>\n' +
        '        <br>';
    html += '<table cellpadding=3 cellspacing=1 align=center class=tableborder1>\n' +
        '                <tr>\n' +
        '                    <td valign=middle align=center height=25 background="../images/bg2.gif" colspan="5">\n' +
        '                        <font color="#ffffff"><b>商品购物清单</b></font>\n' +
        '                    </td>\n' +
        '                </tr>';

    for (var i = 0; i < list.length; i++) {
        html += '              <tr>\n' +
            '                    <td class=tablebody2 valign=middle align=center width="">' + (i + 1) + '\n' +
            '    \n' +
            '                    </td>\n' +
            '                    <td class=tablebody1 valign=middle width="">\n' +
            '                        &nbsp;&nbsp;<a href="/productDetail.html?' + list[i].book.id + '">' + list[i].book.name + '</a>\n' +
            '                    </td>\n' +
            '                    <td class=tablebody2 valign=middle align=center width="">价格:' + list[i].book.price + '</td>\n' +
            '                    <td class=tablebody1 valign=middle align=center width="">数量：' + list[i].num + '</td>\n' +
            '                    <td class=tablebody2 valign=middle align=left width="">小计：￥' + list[i].book.price * list[i].num + '</td>\n' +
            '                </tr>\n' +
            '    \n'

    }
    html += '    \n' +
        '                <tr>\n' +
        '                    <td class=tablebody1 valign=middle align=center colspan="4">　</td>\n' +
        '                    <td class=tablebody1 valign=middle align=left width="">合计：<font color="#ff0000"><b>￥ ' + list[0].order.cost + ' \n' +
        '                    </b></font></td>\n' +
        '                </tr>' +
        '</table>';
    $("#view-order-detail").html(html);

}