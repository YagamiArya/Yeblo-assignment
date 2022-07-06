<!Doctype html>
<html>
    <head>
        <style>
            body{
                background-color: lavender;
                display: flex;
                justify-content: center;
                align-content: center;
            }
            .container{
                padding: 200px;
                
            }
            .error{
            padding:200px;
            }
        </style>
    </head>
    <body><div class="container">
        <form method="post" action="/showtable">
        Enter the table category code:
        <input name="CategoryCode" type="text">
        <a href="#"><button type="submit">Search Table</button></a>
            </form>
        </div>
        <div class="error">${errorMSG}</div>
    </body>
</html>