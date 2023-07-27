<!DOCTYPE html>
<html>
<head>
    <title>My Page</title>
    <!-- Add the Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <style>
        body {
            background-image: url("koala.jpeg");
            background-size: cover; 
            background-position: contain; 
        }
    </style>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="text-center">
                    <h1 class="text-light">Welcome to the PetShop</h1>
                </div>
                <div class="d-flex justify-content-center mt-4">
                    <a href="login.jsp" class="btn btn-outline-warning btn-lg mr-3">Login</a>
                    <a href="formreg.html" class="btn btn-outline-success btn-lg">Registrati</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Add the Bootstrap JS and jQuery (required for Bootstrap) -->
    <script src="./api.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>