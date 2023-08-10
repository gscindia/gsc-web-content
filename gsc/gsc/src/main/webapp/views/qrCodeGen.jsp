<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QR Code Generator</title>
    <script src="/asset/js/jquery-3.6.0-min.js"></script>
    <script src="/asset/js//qrcode.min.js"></script>
</head>
<body>
    <div id="qrcode" data-content='${content}'></div>

    <script>
        $(document).ready(function() {
            var qrCode = new QRCode(document.getElementById("qrcode"), {
                text: $('#qrcode').data('content'), // Replace with your desired URL or text
                width: 128,
                height: 128
            });
        });
    </script>
</body>
</html>
