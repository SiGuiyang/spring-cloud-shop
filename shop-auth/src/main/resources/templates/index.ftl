<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<script src="/webjars/jquery/3.2.1/jquery.min.js" ></script>
<script type="text/javascript">

    let code = window.location.href.split('?')[1]

    $(function () {
        let form = $("<form></form>")
        form.attr('name',"oauthToken")
        form.attr('action',"/oauth/token")
        form.attr('method','post')
        let input2 = $("<input type='hidden' name='grant_type' />")
        input2.attr('value','authorization_code')
        let input3 = $("<input type='hidden' name='client_id' />")
        input3.attr('value','client4')
        let input4 = $("<input type='hidden' name='client_secret' />")
        input4.attr('value','111111')
        let input5 = $("<input type='hidden' name='code' />")
        input5.attr('value',''+code.split('=')[1]+'')
        let input6 = $("<input type='hidden' name='redirect_uri' />")
        input6.attr('value','http://127.0.0.1:8095')
        let input7 = $("<input type='submit' name='authorize' value='submit input' />")
        form.append(input2)
        form.append(input3)
        form.append(input4)
        form.append(input5)
        form.append(input6)
        form.append(input7)
        form.appendTo("body")
        form.css('display','none')
        form.submit()
    })

</script>

</body>
</html>


