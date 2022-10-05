package it.beije.hopper.ecommerceMod.items;

import java.util.*;


public class Cart {
    //Product--> number of products

    private Map<Product, Integer > numOfProductsMap = new HashMap<>();//# of a product
    private Map<Product, Double > discountMap = new HashMap<>();// discount associated with a product


    public void addProduct(Product product, Double discount ){
        if( numOfProductsMap.containsKey(product)){
            Integer newVal = numOfProductsMap.get(product);
            numOfProductsMap.replace(product, ++newVal );
        }else{
            numOfProductsMap.put(product, 1 );
            discountMap.put(product, discount);
        }

    }


    public Collection<Product> getAllItemsInCart(){

        return numOfProductsMap.keySet();
    }
    //Total cost of the cart
    public Double totalCostofCart(){
        Double total = 0.0;
        for(Product product : numOfProductsMap.keySet()){
            total+= totalCostOfProducttype(product);
        }
        return total;
    }

    //Check if cart is Empty
    public boolean isEmpty(){
        return numOfProductsMap.isEmpty();
    }
    public String toString(){
        StringBuffer outProducts = new StringBuffer();
        outProducts.append("Cart contains: \n");

        for( Product product: numOfProductsMap.keySet() ){
            outProducts.append( product + "->  Quantity:" + numOfProductsMap.get(product) + " - Total per type Cost: "+totalCostOfProducttype(product)
                    +" - Discount: "+ discountMap.get(product)* numOfProductsMap.get(product) +"\n");
        }
        return outProducts.toString();
    }

    //returns the total amount/cost of the products of type "product" in the cart.
    private Double totalCostOfProducttype( Product product){
        return product.getPrice()* (this.numOfProductsMap.get(product) ) - (this.discountMap.get(product)*this.numOfProductsMap.get(product) );
    }



}
