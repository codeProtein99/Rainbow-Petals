let cart = document.querySelector('.shoppng-cart');
//To enable the cart:
//For further project work:
// document.querySelector('#cart').onclick = () =>{
//     cart.classList.toggle('active');
//     login.classList.remove('active');
// }

// let login = document.querySelector('.login-form');

// document.querySelector('#login').onclick = () =>{
//     login.classList.toggle('active');
//     cart.classList.remove('active');
// }
// window.onscroll = () =>{
//     cart.classList.remove('active');
//     login.classList.remove('active');
// }

document.querySelector('#cart').onclick = () =>{
        window.location.href = "http://localhost:8080/cart";
    }

    
//Here we have initialized the Swiper class and made an object of the swiper 
//class and specified the functionality of the swiper carousel
var swiper = new Swiper(".home-slider",{
    autoplay:{
        delay:3500,
        disableOnInteraction:false,
    },
    grabCursor:true,
    loop: true,
    centeredSlides:true,
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
});

// var swiper2 = new Swiper(".menu-slider",{
//     grabCursor:true,
//     loop: true,
//     autoHeight:true,
//     centeredSlides:true,
//     spaceBetween:20,
//     pagination: {
//         el: '.swiper-pagination',
//         clickable:true,
//         type: 'bullets'
//       },
// });

var swiper = new Swiper(".menu-slider", {
    grabCursor: true,
    loop: true,
    autoHeight: true,
    centeredSlides: true,
    spaceBetween: 20,
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
      type: 'bullets' // Display number of pages as bullets
    },
  });

  //Selecting the boxes of the menu box for acdding to the art option 
  let previewContainer = document.querySelector(".menu-preview-container"); 
  let previewBox = previewContainer.querySelector(".menu-preview");

  document.querySelector(".menu .box").forEach(menu=>{
    menu.onclick = () =>{
        previewContainer.style.display = 'flex';
        let name = menu.getAttribute('data-name');
        previewBox.forEach(preview =>{
            let target = preview.getAttribute('data-target');
            if(name == target){
                preview.classList.add('active');
            }
        })
    }
  });