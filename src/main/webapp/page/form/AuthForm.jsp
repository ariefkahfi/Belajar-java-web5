<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication Form</title>
</head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<body>

    <form>
        <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" id="username" placeholder="Username"/></td>
                <td id="err-username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" id="password" placeholder="Password"/></td>
                <td id="err-password"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Login"/></td>
            </tr>
        </table>
    </form>


</body>
    <script>
        $(document).ready(function(){
            $('form').submit(function(){
               var username = $('#username').val();
               var password = $('#password').val();

               if(username ==='' || password===''){

                   if(username===''){
                    $('#err-username').text('Username field still empty');
                   }else{
                    $('#err-username').text('');
                   }

                   if(password===''){
                    $('#err-password').text('Password field still empty');
                   }else{
                    $('#err-password').text('');
                   }

                   return false;
               }else{
                  $('form').attr('method','POST');
                  $('form').attr('action','/arief/form');
               }

            });
        });
    </script>
</html>
