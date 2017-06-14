package adechinan.kayode.com.android_quick_start.domains.category;


import com.orm.SugarRecord;

public class CategoryPojo extends SugarRecord{

    private String image;
    private String text;

    public CategoryPojo(){}

    public CategoryPojo(String image, String text){
        this.image =image;
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    
}
