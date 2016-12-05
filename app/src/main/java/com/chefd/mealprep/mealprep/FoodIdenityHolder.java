package com.chefd.mealprep.mealprep;


public class FoodIdenityHolder {

    private Integer stringId;
    private Integer carbsId;
    private Integer proteinId;
    private Integer vegFruitId;
    private Integer imageId;

    public FoodIdenityHolder(Integer image, Integer string, Integer carbs, Integer proteins, Integer vegFruit) {
        imageId = image;
        stringId = string;
        carbsId = carbs;
        proteinId = proteins;
        vegFruitId = vegFruit;
    }

    //Accessors
    public Integer getStringId() {
        return stringId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public Integer getCarbsId() {
        return carbsId;
    }

    public Integer getProteinId() {
        return proteinId;
    }

    public Integer getVegFruitId() {
        return vegFruitId;
    }

    //Mutators
    public void setStringId(Integer stringId) {
        this.stringId = stringId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public void setCarbsId(Integer carbsId) {
        this.carbsId = carbsId;
    }

    public void setProteinId(Integer proteinId) {
        this.proteinId = proteinId;
    }

    public void setVegFruitId(Integer vegFruitId) {
        this.vegFruitId = vegFruitId;
    }
}

