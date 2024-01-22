var arr_hinh=[
   "img/1.png",
   "img/2.png",
   "img/3.png"
];
var arr_mota=[
    "Thời trang nhiều màu ",
    "Nhiều loại chất liệu",
    "Cho cả nam và nữ",
]
var index = 0;
function prev(){
    index --;
    if(index <- 0) index = arr_hinh.length-1;
    document.getElementById("hinh").src=arr_hinh[index];
    document.getElementById("mota").innerText = arr_mota[index];
}
function next(){
    index ++;
    if(index==arr_hinh.length) index=0;
    document.getElementById("hinh").src=arr_hinh[index];
    document.getElementById("mota").innerText = arr_mota[index];
}