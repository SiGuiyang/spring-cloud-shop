<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<script src="/webjars/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

    $(function () {
        let form = $("<form></form>")
        form.attr('name', "confirmationForm")
        form.attr('action', "/oauth/authorize")
        form.attr('method', 'post')
        let input1 = $("<input type='hidden' name='user_oauth_approval' />")
        input1.attr('value', 'true')
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

</body>
</html>


