function MM_swapImgRestore() { //v3.0
    var i, x, a = document.MM_sr;
    for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++) x.src = x.oSrc;
}

function MM_preloadImages() { //v3.0
    var d = document;
    if (d.images) {
        if (!d.MM_p) d.MM_p = new Array();
        var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
        for (i = 0; i < a.length; i++)
            if (a[i].indexOf("#") != 0) {
                d.MM_p[j] = new Image;
                d.MM_p[j++].src = a[i];
            }
    }
}

function MM_findObj(n, d) { //v4.0
    var p, i, x;
    if (!d) d = document;
    if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
        d = parent.frames[n.substring(p + 1)].document;
        n = n.substring(0, p);
    }
    if (!(x = d[n]) && d.all) x = d.all[n];
    for (i = 0; !x && i < d.forms.length; i++) x = d.forms[i][n];
    for (i = 0; !x && d.layers && i < d.layers.length; i++) x = MM_findObj(n, d.layers[i].document);
    if (!x && document.getElementById) x = document.getElementById(n);
    return x;
}

function MM_swapImage() { //v3.0
    var i, j = 0, x, a = MM_swapImage.arguments;
    document.MM_sr = new Array;
    for (i = 0; i < (a.length - 2); i += 3)
        if ((x = MM_findObj(a[i])) != null) {
            document.MM_sr[j++] = x;
            if (!x.oSrc) x.oSrc = x.src;
            x.src = a[i + 2];
        }
}


function checkReg() {
    var temp;
    temp = String(document.reg.password.value);
    if (document.reg.id.value === "") {
        return false;
    }
    if (document.reg.password.value === "") {
        $("#reg-inform-password").text("请输入密码...").css("color", "red");
        return false;
    } else if (temp.length < 6 || temp.length > 8) {
        $("#reg-inform-password").text("您的密码少于6位或多于8位...").css("color", "red");

        return false;
    } else {
        $("#reg-inform-password").text("OK").css("color", "green");
    }
    if (document.reg.password2.value === "") {
        $("#reg-inform-password2").text("请再次输入密码...").css("color", "red");
        return false;
    } else if (document.reg.password.value !== document.reg.password2.value) {
        $("#reg-inform-password2").text("两次密码不一致...").css("color", "red");
        document.reg.password2.value = "";
        return false;
    } else {
        $("#reg-inform-password2").text("OK").css("color", "green");
    }

    if (document.reg.city.value === "") {
        return false;
    }
    if (document.reg.street === "") {
        return false;
    }
    return true;

}


/**
 * 判断注册名称 是否可用
 * @param regName
 */
function isRegNameValid(regName) {

    if (regName == null || regName === "") {
        $("#reg-inform-name").text("名字不可为空").css("color", "red");
    }
    else {
        $.ajax({
            url: '/customer/isValid/' + regName,
            type: "GET",
            success: function (res) {
                //用户名可用， 可以注册
                if (res.msg === "OK") {
                    $("#reg-inform-name").text(" 可用 ").css("color", "green");
                } else {
                    $("#reg-inform-name").text("用户名已存在").css("color", "red");
                }
            },
            error: function () {
                $("#reg-inform-name").text("服务器不可用 ").css("color", "red");
            }

        })
    }

}

/**
 * 注册
 */
function register() {
    if (checkReg()) {
        var name = $("#reg_form").find(':input[name="name"]').val();
        var password = $("#reg_form").find(':input[name="password"]').val();
        var country = $("#reg_form").find(':input[name="country"]').val();
        var province = $("#reg_form").find(':input[name="province"]').val();
        var city = $("#reg_form").find(':input[name="city"]').val();
        var street = $("#reg_form").find(':input[name="street"]').val();
        var address = country + "#" + province + "#" + city + "#" + street;
        var zip = $("#reg_form").find(':input[name="zip"]').val();
        var telephone = $("#reg_form").find(':input[name="telephone"]').val();
        var email = $("#reg_form").find(':input[name="email"]').val();

        var regData = {
            "name": name,
            "password": password,
            "address": address,
            "zip": zip,
            "telephone": telephone,
            "email": email
        };
        console.log("注册信息： ");
        console.log(regData);
        $.ajax({
            url: "/customer",
            contentType: "application/json",
            type: "POST",
            data: JSON.stringify(regData),
            dataType: "JSON",
            success: function (res) {
                if (res.msg === "OK") {
                    alert("牢记您的信息：\n 用户名:  " + name + "\n密码: " + password);
                    $(window).attr("location", "/login.html")
                } else {
                    alert("注册失败。。。")
                }
            },
            error: function () {
                alert("注册失败。。。")
            }

        })
    }
}

/**
 * 修改用户信息
 */

function updateCustomer() {

    if (checkReg()) {

        var id = $("#update-form").find(':input[name="id"]').val();
        var name = $("#update-form").find(':input[name="name"]').val();
        var password = $("#update-form").find(':input[name="password"]').val();
        var country = $("#update-form").find(':input[name="country"]').val();
        var province = $("#update-form").find(':input[name="province"]').val();
        var city = $("#update-form").find(':input[name="city"]').val();
        var street = $("#update-form").find(':input[name="street"]').val();
        var address = country + "#" + province + "#" + city + "#" + street;
        var zip = $("#update-form").find(':input[name="zip"]').val();
        var telephone = $("#update-form").find(':input[name="telephone"]').val();
        var email = $("#update-form").find(':input[name="email"]').val();

        var updateData = {
            "id": id,
            "name": name,
            "password": password,
            "address": address,
            "zip": zip,
            "telephone": telephone,
            "email": email
        };
        console.log("更新信息");
        console.log(updateData);
        $.ajax({
            url: "/customer",
            contentType: "application/json",
            async: true,
            type: "PUT",
            data: JSON.stringify(updateData),
            dataType: "json",
            success: function (res) {
                if (res.msg === "OK") {
                    //更新cookie信息
                    $.cookie('customer', JSON.stringify(updateData), {path: '/', expires: 1});
                    $('<div>').appendTo('body').addClass('alert alert-success').html('^__^ 修改成功').show().delay(2000).fadeOut();

                } else {
                    $('<div>').appendTo('body').addClass('alert alert-danger').html('服务器不可用').show().delay(2000).fadeOut();
                }
            },
            error: function () {
                $('<div>').appendTo('body').addClass('alert alert-danger').html('服务器不可用').show().delay(2000).fadeOut();
            }

        })
    }

}

/**
 * 登录
 */
function login() {


    $.removeCookie('customer', {path: "/"});
    var name = $("#loginName").val();
    var password = $("#loginPassword").val();
    var data = {
        "name": name,
        "password": password
    };
    console.log("登录信息");
    console.log(data);

    $.ajax({
        contentType: "application/json",
        url: "/customer/login",
        type: "POST",
        data: JSON.stringify(data),
        dataType: "JSON",
        success: function (res) {
            if (res.msg !== "OK") {
                $("#login-inform").text("信息有误。。").css("color", "red");
            } else {
                //将登录的用户信息保存进 cookie
                var cus = res.data;
                cus.password = data.password;
                var customerInfo = JSON.stringify(cus);
                console.log("登录后的信息。。。");
                console.log(cus);
                $.cookie("customer", customerInfo, {path: "/", expires: 1});
                $(window).attr("location", "/index.html")
            }
        },
        error: function () {
            $('<div>').appendTo('body').addClass('alert alert-danger').html('服务器不可用').show().delay(500).fadeOut();
        }
    })

}

/**
 * 更新购物车信息
 *
 * @param cartMessage
 */
function updateCart(cartMessage) {

    var cookie = $.cookie('customer');
    var cus = JSON.parse(cookie);

    var strings = cartMessage.toString().split("_");
    var bookid = strings[1];
    var newNum = strings[2];
    var data = {
        "num": newNum,
        "customer": {
            "id": cus.id
        },
        "book": {
            "id": bookid
        }
    };

    console.log(data);

    $.ajax({
        url: '/cart',
        contentType: "application/json",
        data: JSON.stringify(data),
        type: "PUT",
        dataType: 'JSON',
        success: function (res) {
            if (res.msg === "OK") {
                $.ajax({
                    url: '/cart/customer/' + cus.id + '?page=1&pageSize=5',
                    type: 'GET',
                    success: function (res) {
                        viewCartList(res.data.list)
                    }
                })
            }
        },
        error: function () {

            $('<div>').appendTo('body').addClass('alert alert-danger').html('更新失败').show().delay(500).fadeOut();
        }
    })

}

/**
 * 删除购物车
 * @param cartId  传入购物车   cart_id, 切割之后获取 id
 */

function deleteCart(cartId) {
    /*
        cartId = cartId.toString().split("_")[1];*/
    console.log(cartId);

    $.ajax({
        url: '/cart/' + cartId,
        type: "DELETE",
        success: function (res) {
            if (res.msg === "OK") {
                $("#mybody").load("#cart-list-table");
            } else {
                $('<div>').appendTo('body').addClass('alert alert-danger').html('服务不可用').show().delay(1000).fadeOut();
            }
        }, error: function () {
            $('<div>').appendTo('body').addClass('alert alert-danger').html('服务不可用').show().delay(1000).fadeOut();
        }

    })
}

/**
 * 清空购物车
 */
function clearCart() {
    var cookie = $.cookie('customer');
    var cus = JSON.parse(cookie);
    var cusId = cus.id;

    $.ajax({

        url: '/cart/customer/' + cusId,
        type: "DELETE",
        success: function (res) {
            if (res.msg === "OK") {
                //重新加载 table
                $('<div>').appendTo('body').addClass('alert alert-success').html('更新成功').show().delay(500).fadeOut();
                $("#mybody").load("#cart-list-table");

            }
        },
        error: function () {
            $('<div>').appendTo('body').addClass('alert alert-danger').html('更新失败').show().delay(500).fadeOut();
        }


    })
}

/**
 * 添加购物车
 * @param bookid
 */

function add2Cart(bookid) {

    checkLogin();
    var cookie = $.cookie('customer');
    var cus = JSON.parse(cookie);
    var cart = {
        "num": 1,
        "customer": {
            "id": cus.id
        },
        "book": {
            "id": bookid
        }
    };
    console.log(cart.customer.id + "___" + cart.book.id + "___" + cart.num);
    $.ajax({
        contentType: "application/json",
        type: "POST",
        url: "/cart",
        data: JSON.stringify(cart),
        dataType: "JSON",
        success: function (res) {
            if (res.msg === "OK") {
                $('<div>').appendTo('body').addClass('alert alert-success').html('^_^ 添加成功').show().delay(2000).fadeOut();
            } else {
                $('<div>').appendTo('body').addClass('alert alert-danger').html('× 服务不可用').show().delay(2000).fadeOut();
            }
        },
        error: function () {
            $('<div>').appendTo('body').addClass('alert alert-danger').html('× 服务不可用').show().delay(500).fadeOut();
        }

    });
}

/**
 * 删除订单。。。
 * @param orderid
 */
function deleteOrder(orderid) {

    $.ajax({
        url: '/order/' + orderid,
        type: "DELETE",
        success: function (res) {

            if (res.msg === "OK") {
                $("#order-list-body").load("#order-list");
                $('<div>').appendTo('body').addClass('alert alert-success').html('删除成功').show().delay(2000).fadeOut();
            }
        },
        error: function () {
            $('<div>').appendTo('body').addClass('alert alert-danger').html('删除失败').show().delay(2000).fadeOut();
        }

    })
}

/**
 * 检查是否登录
 */

function checkLogin() {

    if ($.cookie('customer')) {
        console.log("已经登录");
        return true;
    } else {
        if (confirm("您未登录，是否现在登录？")) {
            $(window).attr('location', "/login.html")
        } else {
            $(window).attr('location', "/login.html")
        }
    }

    return false;
}

/**
 * 退出登录
 */
function logout() {
    $.removeCookie('customer', {path: "/"});
    $('<div>').appendTo('body').addClass('alert alert-success').html('退出成功').show().delay(1500).fadeOut();

    setTimeout(function () {
        $(window).attr('location', '/index.html')
    }, 1500)

}


/**
 * 生成订单二维码使用
 * @param orderid 订单id
 */
function drawQrCodeImgByOrderId(orderid) {

    $.ajax({
        url: '/order/' + orderid + '/qrcode',
        type: "POST",
        success: function (res) {
            if (res.msg === "OK") {
                var qrcode = res.data;
                $("#order-content").empty().qrcode({width: 240, height: 240, text: qrcode});
            }
            else {
                alert("生成订单失败。。")
            }
        },
        error: function () {
            alert("生成订单失败。。")
        }

    })

}

function searchBook() {

    var params = {};

    if ($("#des").val()) {
        console.log("des");
        params.des = $("#des").val()
    }
    if ($("#fromPrice").val()) {
        console.log("from");
        params.fromPrice = $("#fromPrice").val();
    }
    if ($("#toPrice").val()) {
        console.log("toprice");
        params.toPrice = $("#toPrice").val();
    }
    if (JSON.stringify(params) === "{}") {
        $('<div>').appendTo('body').addClass('alert alert-success').html(' 请输入查询条件').show().delay(2000).fadeOut();
        return;
    }
    console.log(params);
    $.ajax({
        url: '/book/search',
        type: "GET",
        data: params,
        success: function (res) {
            //返回分页书本的数据
            if (res.msg === "OK") {
                if (res.data.length === 0) {
                    $('<div>').appendTo('body').addClass('alert alert-danger').html('无符合条件的商品 ！ ').show().delay(2000).fadeOut();
                    return;
                }
                viewBookList(res.data);
                $("#ui-page").hide();
            }
        }, error: function () {
            $('<div>').appendTo('body').addClass('alert alert-danger').html('服务不可用').show().delay(2000).fadeOut();
        }
    })

}


function verifyemail(str) {
    var reg = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
    if (reg.test(str)) {
        $("#reg-inform-email").text("OK").css("color", "green");
        return true;
    } else {
        $("#reg-inform-email").text("E-mail格式不合法").css("color", "red");
        document.reg.email.value = "";
        return false;
    }
}

function verifyPost(str) {
    var reg = /^[1-9][0-9]{5}$/;
    if (reg.test(str)) {
        $("#reg-inform-zip").text("OK").css("color", "green");
        return true;
    } else {
        $("#reg-inform-zip").text("邮编格式错误").css("color", "red");
        document.reg.zip.value = "";
        return false;
    }
}

function verifyPhone(str) {
    var reg = /^(\+86)|(86)?1[3,5,8]{1}[0-9]{1}[0-9]{8}$/;
    //  var reg = /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/;
    if (reg.test(str)) {
        $("#reg-inform-telephone").text("OK").css("color", "green");
        return ture;
    } else {
        $("#reg-inform-telephone").text("手机号不合法").css("color", "red");
        document.reg.telephone.value = "";
        return false;
    }
}

function verifyCity(str) {
    if (str === "" || null == str) {
        $("#reg-inform-city").text("不可为空").css("color", "red");
        return false;
    }
    $("#reg-inform-city").text("OK").css("color", "green");
    return true;
}

function verifyStreet(str) {
    if (str === "" || null == str) {
        $("#reg-inform-street").text("地址不可为空").css("color", "red");
        return false;
    }
    $("#reg-inform-street").text("OK").css("color", "green");
    return true;
}