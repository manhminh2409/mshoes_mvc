<!doctype html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%@ include file="../css.jsp"%>
</head>
<body>
    <div class="card col-lg-10 mx-auto py-3 mt-5" >
        <div class="card-body">
            <h5 class="card-title ps-3 py-3">Product | Create new product</h5>
            <%--@elvariable id="product" type="java"--%>
            <form:form action="/products/add" method ="POST" enctype="multipart/form-data" modelAttribute="product">

                <div class="row mt-3 align-items-center">
                    <label class="col-lg-2 text-end py-2" for="productName">
                        Product name:
                    </label>
                    <div class="col-lg-3">
                        <form:input path="productName" type="text" cssClass="form-control"  id ="productName"/>
                        <form:errors path="productName" cssClass="error text-danger" cssStyle="font-size: 14px;"></form:errors>
                    </div>
                </div>
                <div class="row mt-3 align-items-center">
                    <label class="col-lg-2 text-end py-2" for="productDescription">
                        Product description:
                    </label>
                    <div class="col-lg-3 ">
                        <form:input path="productDescription" type="text" cssClass="form-control" id="productDescription" />
                    </div>
                </div>
                <div class="row mt-3 align-items-center">
                    <label class="col-lg-2  text-end py-2" for="productPrice">
                        Price:
                    </label>
                    <div class="col-lg-3">
                        <form:input path= "productPrice" type="text" cssClass="form-control" id="productPrice"/>
                    </div>

                    <label class="col-lg-2 text-end py-2 " for="productTotal">
                        Total:
                    </label>

                    <div class=" col-lg-3 ">
                        <form:input path="productTotal" type="text" cssClass="form-control" id ="productTotal" />
                    </div>
                </div>

                <div class="row mt-3 align-items-center">
                    <label class="col-lg-2 text-end py-2" for="productStatus">
                        Status:
                    </label>
                    <div class="col-lg-3">
                        <form:select path="productStatus" cssClass="form-control"  id = "productStatus">
                            <form:option value="0">Enable</form:option>
                            <form:option value="1">Disable</form:option>
                        </form:select>
                    </div>
                </div>

                <div class="row align-items-center">
                    <div class="col-md-12 mx-auto text-center">
                        <hr class=" border-top border-1 border-success">
                    </div>
                </div>

                <div class="row mt-3 ">
                    <div class="col-md-12 text-center">
                        <button type="submit" name="" class="btn btn-success mx-2" ><i class="fa-solid fa-right-to-bracket"></i> Create</button>
                        <button type="button" class="btn btn-secondary"><a href="/products" class="text-decoration-none text-light">Back</a> <i class="fa-solid fa-arrow-right-from-bracket"></i></button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    <%@ include file="../javascript.jsp"%>
</body>
</html>