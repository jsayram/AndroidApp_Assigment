package com.chefd.mealprep.mealprep;

/**
 * Created by artisja on 10/7/2016.
 */

public class FoodIdenityHolder {

    private Integer stringId;
    private Integer imageId;

    public FoodIdenityHolder(Integer image,Integer string) {
        imageId = image;
        stringId = string;
    }

    //Accessors
    public Integer getStringId() {
        return stringId;
    }

    public Integer getImageId() {
        return imageId;
    }

    //Mutators
    public void setStringId(Integer stringId) {
        this.stringId = stringId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
}
