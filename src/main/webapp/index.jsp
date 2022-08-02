<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
<br/><br/><br/><br/><br/>
<form action="login" method="post">
    <table align="center">

        <tr>
            <td colspan="2"><h2>Giriş Sayfasi</h2></td>
        </tr>
        <tr>
            <td>Kullanici</td>
            <td><input type="text" name="kullanici" /></td>
        </tr>
        <tr>
            <td>Sifre</td>
            <td><input type="password" name="sifre" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td><input type="submit" value="Giriş" /></td>
        </tr>
    </table>
</form>
<form action="Register" method="get"><tr>
    <td>&nbsp;</td>
    <td><input type="submit" value="Register" /></td>
</tr></form>
</body>
</html>