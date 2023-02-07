package org.vendingmachine.inventory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {

    private static final int MAX_PRODUCT_IN_AISLE = 20;
    private Map<Integer, Product> aisleToProductMap;
    private Map<String, Integer> productIdToCountMap;
    private Queue<Integer> availableAisles;

    public Inventory(int aisleCount){
        aisleToProductMap = new HashMap<>();
        productIdToCountMap = new HashMap<>();
        availableAisles = new LinkedList<>();
        //Initialiaze Aisle
        for(int aisle = 1; aisle <= aisleCount; aisle++){
            availableAisles.add(aisle);
        }
    }

    public void addProduct(Product product) throws Exception {
        String productId = product.getProductId();

        int productCount = productIdToCountMap.getOrDefault(productId, 0);
        if(productCount == MAX_PRODUCT_IN_AISLE){
            throw new Exception("The Aisle is filled with max number of this product");
        }
        if(productCount == 0){
            if(availableAisles.isEmpty()){
                throw new Exception("No Space to Add product");
            }
            aisleToProductMap.put(availableAisles.poll(), product); // Add the first item in the aisle
        }

        productIdToCountMap.put(productId, productCount + 1); // Assuming we can add multime
    }

    public Product getProductAt(int aisleNumber){
        return aisleToProductMap.get(aisleNumber);
    }

    public boolean checkIfProductAvailable(String productId){
       int productCount = productIdToCountMap.getOrDefault(productId, 0);
       return productCount > 0;
    }

    public void deductProductCount(int aisleNumber){
        String productId = aisleToProductMap.get(aisleNumber).getProductId();
        int updatedProductCount = productIdToCountMap.get(productId) - 1;

        if(updatedProductCount == 0){
            // stock of this product is finished.
            // hence remove product from countMap, remove aisleNumber from aisleMap
            // add the aisleNumber to availableAilse
            productIdToCountMap.remove(productId);
            aisleToProductMap.remove(aisleNumber);
            availableAisles.offer(aisleNumber);
        }else{
            productIdToCountMap.put(productId, updatedProductCount); // Update Product Count
        }

    }
}
