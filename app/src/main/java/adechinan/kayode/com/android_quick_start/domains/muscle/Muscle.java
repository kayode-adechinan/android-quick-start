package adechinan.kayode.com.android_quick_start.domains.muscle;

/**
 * Created by atsk1618 on 4/5/2017.
 */

public class Muscle {

    private String name;
    private int imageID;

    public Muscle(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
