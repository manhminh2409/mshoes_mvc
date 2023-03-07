<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>List</title>
    <%@ include file="../css.jsp"%>
</head>
<body>
    <div class="col-lg-10 mx-auto mt-5">
        <div class="card">
            <h5 class="card-title ps-3 py-3">Product | List all products</h5>

            <div class="card-body">
                <table class="table table-striped pb-3">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Product's name</th>
                        <th scope="col">Product's price</th>
                        <th scope="col">Product's total</th>
                        <th scope="col">Created date</th>
                        <th scope="col">Last modified</th>
                        <th scope="col" colspan="2" class="text-center">Options</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.productId}</td>
                            <td>${product.productName}</td>
                            <td>${product.productPrice}</td>
                            <td>${product.productTotal}</td>
                            <td>${product.productCreatedDate}</td>
                            <td>${product.productLastModified}</td>
                            <td class="text-center"><a href="/products/${product.productId}" class="bg-success text-light p-2 rounded "><i class="fa-regular fa-pen-to-square"></i></a></td>
                            <td class="text-center"><a href="/products/${product.productId}" class="bg-danger text-light p-2 rounded" data-bs-toggle="modal" data-bs-target="#product${product.productId}"><i class="fa-solid fa-trash"></i></a></td>
                        </tr>

                        <!-- Modal -->
                        <div class="modal fade" id="product${product.productId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Confirm delete <strong>#${product.productId}</strong></h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        After confirmation, <strong><u>${product.productName}</u></strong> is moved to the disable list.
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        <a href="/products/delete/${product.productId}" class="btn btn-danger">Confirm</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="/products/form_add" class="bg-success text-light ms-3 mt-3 p-2 rounded d-inline-block">Create product</a>

            </div>
        </div>
    </div>


    <%@ include file="../javascript.jsp"%>
</body>
</html>