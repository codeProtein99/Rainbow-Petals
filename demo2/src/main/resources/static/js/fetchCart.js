// Retrieve the products array from local storage
var retrievedProducts = JSON.parse(localStorage.getItem('products'));

// Get the cart container element
var cartContainer = document.getElementById('cartContainer');

// Check if there are products in the cart
if (retrievedProducts && retrievedProducts.length > 0) {
  // Loop through each product in the retrieved array
  retrievedProducts.forEach(function(product) {
    // Create the card element
    var card = document.createElement('div');
    card.className = 'card';

    // Create the card body element
    var cardBody = document.createElement('div');
    cardBody.className = 'card-body';

    // Create the product name element
    var productName = document.createElement('h3');
    productName.textContent = product.name;

    // Create the product image element
    var productImage = document.createElement('img');
    productImage.src = product.image;

    // Create the product price element
    var productPrice = document.createElement('p');
    productPrice.textContent = 'Price: Rs. ' + product.price;

    // Create the product quantity element
    var productQuantity = document.createElement('p');
    productQuantity.textContent = 'Quantity: ' + product.quantity;

    // Append the elements to the card body
    cardBody.appendChild(productName);
    cardBody.appendChild(productImage);
    cardBody.appendChild(productPrice);
    cardBody.appendChild(productQuantity);

    // Append the card body to the card
    card.appendChild(cardBody);

    // Append the card to the cart container
    cartContainer.appendChild(card);
  });
} else {
  // Display a message when the cart is empty
  cartContainer.textContent = 'Your cart is empty.';
}
