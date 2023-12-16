//Here we are going to write the script for adding to the cart.
let product = document.querySelectorAll(".menu .slide .box-container .box");

product.forEach(element =>{
    console.log(element);
    element.addEventListener('click',function(){
        //Fetching the product ID that is mentioned in each of the given products with the attribute data-id.
        let url = element.getAttribute('href');

        fetch(url)
        .then(function(response){
            return response.json();
        })
        .then(function(data){
            let product = {
                 name : data.name,
                 image: data.image,
                 price: data.price,
                 quantity:  data.quantity
            }
            //Retrieveing the already saved products from the loacl storage or if not we create an empty array in the same line:
            var existingProducts = JSON.parse(localStorage.getItem('products')) || [];

            //Adding the new product into the cart:
            existingProducts.push(product);

            //Saving the cart into the local storage again:
            localStorage.setItem('products', JSON.stringify(existingProducts));

            console.log('Anything added',product);

            alert("Product added");

            // localStorage.setItem('name', name);
            // localStorage.setItem('image', image);
            // localStorage.setItem('price', price);
            // localStorage.setItem('quantity', quantity);

            window.location.href = "http://localhost:8080/products";
        })
        .catch(function(error){
            console.log("The Error that occured:" + error);
        })
    })
})

