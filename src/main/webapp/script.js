// Slider Functionality
let slideIndex = 0;

function showSlides() {
    const slides = document.querySelectorAll('.slide');
    slides.forEach((slide, index) => {
        slide.style.display = 'none';
    });
    slideIndex++;
    if (slideIndex > slides.length) { slideIndex = 1; }
    slides[slideIndex - 1].style.display = 'block';
    setTimeout(showSlides, 3000); // Change image every 3 seconds
}

window.onload = function() {
    showSlides();
};

// Modal Functions
function openModal(modalId) {
    document.getElementById(modalId).style.display = 'block';
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
}

function showLoginModal() {
    openModal('loginModal');
}

function showRegisterModal() {
    openModal('registerModal');
}

function showCartModal() {
    openModal('cartModal');
}

function showProductModal(product) {
    document.getElementById('productName').innerText = product.name;
    document.getElementById('productImage').src = product.image;
    document.getElementById('productPrice').innerText = `$${product.price}`;
    openModal('productModal');
}

// Example products
const products = {
    electronics: [
        { name: 'Smartphone', image: 'images/electronics.jpg', price: 299.99 },
        { name: 'Laptop', image: 'images/laptop.jpg', price: 999.99 }
    ],
    fashion: [
        { name: 'T-shirt', image: 'images/tshirt.jpg', price: 19.99 },
        { name: 'Jeans', image: 'images/jeans.jpg', price: 49.99 }
    ],
    home: [
        { name: 'Sofa', image: 'images/sofa.jpg', price: 499.99 },
        { name: 'Lamp', image: 'images/lamp.jpg', price: 89.99 }
    ],
    appliances: [
        { name: 'Refrigerator', image: 'images/refrigerator.jpg', price: 799.99 },
        { name: 'Washing Machine', image: 'images/washing_machine.jpg', price: 599.99 }
    ]
};

function showProducts(category) {
    const productList = document.getElementById('productList');
    productList.innerHTML = ''; // Clear previous products
    products[category].forEach(product => {
        const productElement = document.createElement('div');
        productElement.classList.add('product');
        productElement.innerHTML = `
            <img src="${product.image}" alt="${product.name}">
            <h3>${product.name}</h3>
            <p>$${product.price}</p>
            <button onclick='showProductModal(${JSON.stringify(product)})'>View Details</button>
        `;
        productList.appendChild(productElement);
    });
}

function searchProducts() {
    // Implement search functionality
}

function addToCart() {
    // Implement add to cart functionality
}

function toggleDropdown() {
    document.getElementById('accountDropdown').classList.toggle('show');
}