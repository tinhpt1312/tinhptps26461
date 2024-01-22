function taoCart() {
    var cart = [
        {
            'tensp': 'Áo phông form rộng',
            'gia': 150000,
            'hinh': 'img/Ao phong form rong.png',
            'soluong': 1
        },
        {
            'tensp': 'Áo thun cổ tròn Red Death Redemsion',
            'gia': 85500,
            'hinh': 'img/Ao thun co tron Red Death Redemsion II.png',
            'soluong': 3
        },
        {
            'tensp': 'Áo thun The legend of Zelda',
            'gia': 106400,
            'hinh': 'img/Ao thun The legend of Zelda.png',
            'soluong': 5
        },
        {
            'tensp': 'Tee trơn basic',
            'gia': 58000,
            'hinh': 'img/Tee tron basic.png',
            'soluong': 2
        }
    ];
    sessionStorage.setItem("cart", JSON.stringify(cart));
    alert('Đã tạo cart xong trong sessionStorage')
}
function hiencart()
{   
    var str=`
    <div class="row">
      <div>TT</div>
      <div>Tên SP</div>
      <div>Giá</div>
      <div>Số lượng</div>
      <span>Tiền</span>
    </div>
    `;
    var text = sessionStorage.getItem("cart");
    var cart = JSON.parse(text);
    console.log(cart);
    for(let i=0;i<cart.length;i++)
    {
           sp=cart[i];
           str+=`
    <div class="row">
      <div>${i+1}</div>
      <div>${sp.tensp}</div>
      <div>${sp.gia}</div>
      <div><input onchange='doiSoLuong()' onkeyup="doiSoLuong()"  type='number' value='${sp.soluong}'></div>
      <span>${sp.gia*sp.soluong}</span>
    </div>
    `;
    }
    document.getElementById("giohang").innerHTML=str;
}
function doiSoLuong()
{

  var soluong=event.target.value;
  var gia=event.target.parentElement.previousElementSibling.innerText;
  var tien= soluong*gia;
  event.target.parentElement.nextElementSibling.innerText=tien;

}