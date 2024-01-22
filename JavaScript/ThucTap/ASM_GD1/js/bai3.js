function taoCart(){
var cart = [
 {
  'tensp':'Áo Thun Trơn Tay Lỡ Unisex', 
  'gia': 150000, 
  'hinh':'images/n1a.jpg',
   'soluong':1 
 },
 { 
  'tensp':'Áo nhóm nhiều màu 5h1t station', 
  'gia': 85500, 
   'hinh':'images/n2a.jpg', 
  'soluong':3
 },
 { 
  'tensp':'Áo Dệt Kim Tay Ngắn Cổ Tròn Dáng Ôm', 
  'gia': 106400, 
  'hinh':'images/n3a.jpg', 
  'soluong':5  
 },
 { 
  'tensp':'Áo Trơn Cổ Tròn Nam Nữ Nhiều Màu', 
  'gia': 58000, 
  'hinh':'images/n4a.jpg', 
  'soluong':2  
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