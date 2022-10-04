package it.beije.hopper.ecommerceMod.items;

import java.util.HashMap;
import java.util.Map;


public class Cart {
    //Product--> number of products

    private Map<Product, Integer > mapNumOfProducts = new HashMap<>();//# of a product
    private Map<Product, Double > discountMap = new HashMap<>();// discount associated with a product


    public void addProduct(Product product, Double discount ){
        if( mapNumOfProducts.containsKey(product)){
            Integer newVal = mapNumOfProducts.get(product);
            mapNumOfProducts.replace(product, ++newVal );

        }else{
            mapNumOfProducts.put(product, 1 );
            discountMap.put(product, discount);
        }

    }

    //Total cost of the cart
    public Double totalCostofCart(){
        Double total = 0.0;
        for(Product product : mapNumOfProducts.keySet()){
            total+= totalCostOfProducttype(product);
        }
        return total;
    }

    public String toString(){
        StringBuffer outProducts = new StringBuffer();
        outProducts.append("Cart contains: \n");

        for( Product product: mapNumOfProducts.keySet() ){
            outProducts.append( product + ": " + mapNumOfProducts.get(product) + " - Cost: "+mapNumOfProducts.get(product)+"\n");
        }
        return outProducts.toString();
    }

    //returns the total amount/cost of the products of type "product" in the cart.
    private Double totalCostOfProducttype( Product product){
        return product.getPrice()* (this.mapNumOfProducts.get(product) ) - this.discountMap.get(product) ;
    }



}
