<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" href="/webjars/Semantic-UI/2.2.10/semantic.min.css"/>
</head>
<style type="text/css">
    body {
        background-color: #DADADA;
    }
    body {
        height: 100%;
    }
    .title {
        font-size: 28px !important;
        font-weight: 400 !important;
    }
    .title span{
        font-size: 16px;
        float: right;
    }
    .title a{
        font-size: 16px;
        float: right;
    }
</style>
<body>
<form id="form" action="/oauth/authorize" method='post'>
    <input id="approval" name='user_oauth_approval' value='false' type='hidden'/>
    <input id="approveOrDeny" name='authorize' value='Authorize' type='hidden'/>
    <input id="scope" name='scope.app' value='true' type='hidden'/>
</form>
<div class="ui modal" id="modal">
    <div class="header title">Pager Shop 授权中心
        <a href="javascript:void(0)" onclick="changeUser()">[切换账号]</a>
        <span>${userName} &nbsp;|&nbsp;&nbsp;</span></div>
    <div class="content">
        <p style="line-height: 2.5">
            将允许应用 ${authorizationRequest.clientId} 拥有以下权限：<br>
            <i class="user icon"></i>获取你的用户信息
        </p>
    </div>
    <div class="actions">
        <div class="ui ok button" id="ok">允许</div>
        <div class="ui cancel button" id="no">拒绝</div>
    </div>
</div>
</body>
<script src="/webjars/jquery/3.2.1/jquery.min.js" ></script>
<script src="/webjars/Semantic-UI/2.2.10/semantic.min.js" ></script>
<script>
    $("#modal").modal({closable: false}).modal('show')
    $("#ok").click(function () {
        $("#approval").val("true");
        $("#approveOrDeny").attr("name", "authorize").val("Authorize");
        $("#form").submit();
    })

    $("#no").click(function () {
        $("#approval").val("false");
        $("#approveOrDeny").attr("name", "deny").val("Deny");
        $("#scope").val("false");
        $("#form").submit();
    })
    function changeUser() {
        const getUrlParameters = url =>
        url.match(/([^?=&]+)(=([^&]*))/g).reduce(
                (a, v) => (a[v.slice(0, v.indexOf('='))] = v.slice(v.indexOf('=') + 1), a), {});
        var url = getUrlParameters(window.location.href)['redirect_uri']
        if (url.indexOf('?') == -1) {
            url += '?logout=yes'
        } else {
            url += '&logout=yes'
        }
        window.location.replace(url)
    }
</script>
</html>
