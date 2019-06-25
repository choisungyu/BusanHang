import java.util.Scanner;

public class Place {
    public Place(String trainStationName, int trainNum, int stageNum) {// 위치한 역, 위치한 호차
        this.trainStationName = trainStationName;
        this.trainNum = trainNum;
        this.stageNum = stageNum;
    }

    public String trainStationName;
    public int trainNum=4;
    int stageNum;

    private static Place place;

    private Place() {

    }



    public static Place getInstance() {
        if (place == null) {
            place = new Place();
        }
        return place;
    }


}


