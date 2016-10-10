package com.chefd.mealprep.mealprep;

/**
 * Created by artisja on 10/7/2016.
 */

public class FoodIdenityHolder {

    private Integer stringID;
    private Integer imageID;

    public FoodIdenityHolder(Integer image,Integer string){
        imageID=image;
        stringID=string;
    }
//Accessors

    public Integer getStringID() {
        return stringID;
    }

    public Integer getImageID() {
        return imageID;
    }

//Mutators
    public void setStringID(Integer stringID) {
        this.stringID = stringID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }
}
