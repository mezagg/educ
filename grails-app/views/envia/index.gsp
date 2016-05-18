<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sample title</title>
    </head>
    <body>
        <h1>Slack Service</h1>
        <form action="tree">
            <table>
                <tr>
                    <td>Text:</td>
                    <td><input type="text" name="text"></td>
                </tr>
                 <tr>
                    <td>username:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                 <tr>
                    <td>iconEmoji:</td>
                    <td><input type="text" name="iconEmoji"></td>
                </tr>
                <tr>
                    <td>Title attachment:</td>
                    <td><input type="text" name="attachment.title"></td>
                </tr>
                 <tr> 
                    <td>Text attachment:</td>
                    <td><input type="text" name="attachment.text"></td>
                </tr>
                <tr>
                    <td>Url attachment:</td>
                    <td><input type="text" name="attachment.imageUrl"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td>
                </tr>
                
            </table>
        </form>
    </body>
</html>
