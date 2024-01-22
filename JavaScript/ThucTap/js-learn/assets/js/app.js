function randomId() {
    return Math.floor(Math.random() * 100000);
}



let productss = [
    {
        id: randomId(),
        name: 'Áo kiểu nữ cam đất phối cổ trắng dập ly',
        price: 250000,
        image:
            'https://image.yes24.vn/Upload/productsImage/anhduong201605/1947415_L.jpg?width=550&height=550',
        count: 1,
    },
    {
        id: randomId(),
        name: 'Áo trắng bèo lé đen tay loe dễ thương',
        price: 350000,
        image:
            'https://image.yes24.vn/Upload/productsImage/anhduong201605/1914666_L.jpg?width=550&height=550',
        count: 1,
    },
];

let productssEle = document.querySelector('.productss');

function renderUI(arr) {
    // Code xử lý
}

function renderUI(arr) {
    // ...

    for (let i = 0; i < arr.length; i++) {
        const p = arr[i];
        productssEle.innerHTML += `
            <li class="row">
                <div class="col left">
                    <div class="thumbnail">
                        <a href="#">
                            <img src="${p.image}" alt="${p.name}">
                        </a>
                    </div>
                    <div class="detail">
                        <div class="name"><a href="#">${p.name}</a></div>
                        <div class="description">
                            ${p.description}
                        </div>
                        <div class="price">${convertMoney(p.price)}</div>
                    </div>
                </div>
                <div class="col right">
                    <div class="quantity">
                        <input type="number" class="quantity" step="1" value="${ p.count}" >
                    </div>
                    <div class="remove">
                        <span class="close">
                            <i class="fa fa-times" aria-hidden="true"></i>
                        </span>
                    </div>
                </div>
            </li>
        `;
    }
}


