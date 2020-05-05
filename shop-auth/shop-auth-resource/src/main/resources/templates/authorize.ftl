<html lang="zh">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" href="/webjars/Semantic-UI/2.2.10/semantic.min.css"/>
    <title>Pager 授权中心</title>
</head>

<body>
</body>
<script src="/webjars/jquery/3.2.1/jquery.min.js" ></script>
<script>

    $(function () {
        let form = $("<form></form>")
        form.attr('name', "submitForm")
        form.attr('action', "/oauth/authorize")
        form.attr('method', 'post')
        let input1 = $("<input id = 'approval' type='hidden' name='user_oauth_approval' />")
        input1.attr('value', 'false')
        let input2 = $("<input id='scope' name='scope.app' value='true' type='hidden'/>")
        let input3 = $("<input type='submit' name='authorize' value='submit input' />")
        form.append(input1)
        form.append(input2)
        form.append(input3)
        form.appendTo("body")
        form.css('display', 'none')
        form.submit()
    })

</script>
</html>
