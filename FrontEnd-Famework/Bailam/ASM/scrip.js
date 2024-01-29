var app = angular.module("myapp", ["ngRoute"]);
app.controller("myctrl", function ($scope, $http, $location) {
  $http.get("clothes.json").then(function (sanphams) {
    $scope.sanpham = sanphams.data;
  });

  $scope.orderByMe = function (x) {
    $scope.myOrderBy = x;
  };

  $scope.shirts = $scope.sanpham;

  $scope.$watch("showShirts", function (newValue) {
    if (newValue) {
      // Lọc và sử dụng mảng đã lọc khi checkbox được chọn
      $scope.shirts = $scope.sanpham.filter(function (product) {
        return product.type === "Áo";
      });
    } else {
      // Sử dụng mảng đầy đủ khi checkbox không được chọn
      $scope.shirts = $scope.sanpham;
    }
  });

  $scope.kieu = "";
  $scope.cot = "";
  $scope.onSortChange = function (cot, kieu) {
    $scope.cot = cot;
    $scope.kieu = kieu;
  };

  $scope.shirts = $scope.sanpham;

  $scope.$watch("showShirts", function (newValue) {
    if (newValue) {
      // Lọc và sử dụng mảng đã lọc khi checkbox được chọn
      $scope.shirts = $scope.sanpham.filter(function (product) {
        return product.type === "Áo";
      });
    } else {
      // Sử dụng mảng đầy đủ khi checkbox không được chọn
      $scope.shirts = $scope.sanpham;
    }
  });
  $scope.cart = [];

  $scope.addToCart = function (product) {
    var existingItem = $scope.cart.find((item) => item.id === product.id);

    if (existingItem) {
      existingItem.quantity++;
    } else {
      $scope.cart.push({
        id: product.id,
        img: product.img,
        name: product.name,
        title: product.title,
        price: product.price,
        quantity: 1,
      });
    }
  };
  $scope.updateTotal = function (item) {
    // Cập nhật tổng giá tiền khi quantity thay đổi
    item.total = item.price * item.quantity;

    if (item.quantity === 0) {
      $scope.cart = $scope.cart.filter((cartItem) => cartItem !== item);
    }
  };

  $scope.calculateTotal = function () {
    // Tính tổng tiền của tất cả sản phẩm trong giỏ hàng
    return $scope.cart.reduce((total, item) => total + item.total, 0);
  };

  $scope.proceedToCheckout = function () {
    // Chuyển đến trang thanh toán và truyền danh sách sản phẩm trong giỏ hàng
    $location.path("/Cart").search({ cart: JSON.stringify($scope.cart) });
  };
  $http.get("user.json").then(function (users) {
    $scope.user1 = users.data;
  });

  $scope.login = function () {
    console.log($scope.user1);
    var enteredUsername = $scope.username;
    var enteredPassword = $scope.password;

    // Kiểm tra đăng nhập
    var user = $scope.user1.find(function (prod) {
      return prod.email === enteredUsername && prod.pass === enteredPassword;
    });

    if ($scope.rememberMe) {
      localStorage.setItem("rememberedUsername", $scope.username);
    } else {
      // Nếu không chọn Remember Me, xóa giá trị từ localStorage
      localStorage.removeItem("rememberedUsername");
    }

    console.log("User found:", user);
    if (user) {
      alert("Đăng nhập thành công!");
      // Thực hiện các thao tác cần thiết sau khi đăng nhập
    } else {
      alert("Đăng nhập thất bại. Kiểm tra lại tên đăng nhập và mật khẩu.");
    }
  };
  $scope.register = function () {
    var newName = $scope.newName;
    var newPhone = $scope.newPhone;
    var newEmail = $scope.newEmail;
    var newPass1 = $scope.newPass1;
    var newPass2 = $scope.newPass2;

    // Kiểm tra xem người dùng đã tồn tại chưa

    if ($scope.formDK.$invalid) {
      alert("Form has errors. Please fix them before saving.");
      return;
    } else {
      var userExists = $scope.user1.some(function (prod) {
        return prod.email === newEmail;
      });

      var check = false;
      if (newPass1 == newPass2) {
        check = true;
      }
      if (userExists) {
        alert("Bạn đã đăng kí trước đó rồi");
      } else if (!check) {
        alert("Mật khẩu không giống nhau");
      } else {
        // Thêm người dùng mới vào mảng hoặc ghi vào tệp JSON tùy thuộc vào cách bạn lưu trữ dữ liệu
        $scope.user1.push({
          pass: newPass1,
          email: newEmail,
          name: newName,
          phone: newPhone.toString(),
        });
      }

      console.log(check);
      alert("Đăng ký thành công!");
      // Thực hiện các thao tác cần thiết sau khi đăng ký
    }
  };
});

app.config(function ($routeProvider) {
  $routeProvider
    .when("/chitiet/:idsp", {
      templateUrl: "productdetail.html",
      controller: "myctr1",
    })
    .when("/Cart", {
      templateUrl: "Cart.html",
      controller: "myctr4",
    })
    .when("/Home", {
      templateUrl: "index.html",
    })
    .when("/Gopy", {
      templateUrl: "lienhe.html",
    })
    .when("/NuocHoa", {
      templateUrl: "nuochoa.html",
    })
    .otherwise({
      templateUrl: "product.html",
    });
});

app.controller("myctr1", function ($scope, $routeParams) {
  $scope.idsp = $routeParams.idsp;

  var matchingProduct = $scope.sanpham.find(function (product) {
    return product.id === parseInt($scope.idsp);
  });

  $scope.matchingProduct = matchingProduct;
});

app.controller("myctr4", function ($scope, $routeParams) {
  $scope.cart = JSON.parse($routeParams.cart);

  // Lấy giá trị của tham số cart từ URL
  var cartParam = $routeParams.cart;

  // Kiểm tra xem cart có giá trị không
  if (cartParam) {
    // Parse chuỗi JSON nếu cart có giá trị
    $scope.cart = JSON.parse(cartParam);

    // Tính tổng giá của các sản phẩm trong cart
    $scope.totalPrice = calculateTotalPrice($scope.cart);
  } else {
    // Xử lý trường hợp khi cart không có giá trị
    console.error('Tham số "cart" không được định nghĩa trong URL.');
  }

  // Hàm tính tổng giá
  function calculateTotalPrice(cart) {
    var totalPrice = 0;

    // Duyệt qua từng sản phẩm trong cart và cộng giá vào tổng
    for (var i = 0; i < cart.length; i++) {
      totalPrice += cart[i].price * cart[i].quantity;
    }

    return totalPrice;
  }

  $scope.removeProduct = function (index) {
    // Sử dụng index để xác định vị trí sản phẩm trong mảng và xóa nó
    $scope.cart.splice(index, 1);

    // Sau khi xóa, cập nhật lại tổng giá
    $scope.totalPrice = calculateTotalPrice($scope.cart);
  };
});
