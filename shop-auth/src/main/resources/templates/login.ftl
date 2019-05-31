<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" href="webjars/Semantic-UI/2.2.10/semantic.min.css"/>
</head>
<style type="text/css">

    body {
        height: 100%;
    }

    body > .grid {
        height: 100%;
    }
    .grid{
        opacity:0.8
    }
    .image {
        margin-top: -100px;
    }
    .column {
        max-width: 450px;
        height: 600px;
    }
    .title {
        color: #2b4035;
        margin-bottom: 25px;
        margin-top: 15px !important;
        font-size: 28px;
        font-weight: 400;
    }

    .item {
        height: 60px;
    }

    input {
        height: 45px;
    }

    a {
        color: #32c5d2
    }

    .login {
        margin-bottom: 20px;
        background-color: #47b77d
    }
</style>
<body>
<div class="ui middle aligned center aligned grid">
    <div class="column transition hidden">
        <form id="form" class="ui large form" action="login" method="post" style="border: 0">
            <div class="ui stacked segment">
                <h3 class="title">Pager Shop 授权中心</h3>
                <div class="field item">
                    <div class="ui left icon input">
                        <i class="user icon"></i>
                        <input id="username" name="username" placeholder="用户名">
                    </div>
                </div>
                <div class="field item" style="height: 80px">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input type="password" id="password" name="password" placeholder="密码">
                    </div>
                </div>

                <div id="submit" class="ui fluid large teal submit button login">登录</div>
            </div>
            <div class="ui error message"></div>
        </form>
        <#if RequestParameters.error?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
            <#if Session.SPRING_SECURITY_LAST_EXCEPTION.message == "Bad credentials">
                <div class="ui red message">
                    密码错误
                </div>
            <#else>
                <div class="ui red message">
                    ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
                </div>
            </#if>
        </#if>
    </div>
</div>
</body>
<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/Semantic-UI/2.2.10/semantic.min.js"></script>
<script>
    $('.column').transition({
        animation: 'slide left',
        duration: '1s'
    })
    $('#form').form({
        fields: {
            username: {
                identifier: 'username',
                rules: [
                    {
                        type: 'empty',
                        prompt: '请输入用户名'
                    }
                ]
            },
            password: {
                identifier: 'password',
                rules: [
                    {
                        type: 'empty',
                        prompt: '请输入密码'
                    }
                ]
            },
        }
    });


    $("#submit").click(function () {
        if ($("#username").val() && $("#password").val()) {
            $("#form").submit();
        }
    })

    $('.message .close').on('click', function () {
        $(this).closest('.message').transition('fade');
    })
</script>
</html>
