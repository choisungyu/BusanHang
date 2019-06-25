import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tunnel {

    private static Tunnel tunnel;

    private Tunnel() {
    }


    public static Tunnel getInstance() {
        if (tunnel == null) {
            tunnel = new Tunnel();
        }
        return tunnel;
    }
    void farming(){

        while(true) {

            Inventory inventory = Inventory.getInstance();
            Place place = Place.getInstance();
            Hero hero = Hero.getInstance();


            ArrayList<Weapon> weaponList = new ArrayList();

            inventory.weaponList = weaponList;
            String[] stageInfo = new String[]
                    {"==========================================================================", "" +
                            "                                                                          ",
                            "                       * 터널속에  들어왔습니다                            ",
                            "           * (터널 시간을 1분마다 들어옴 1분 동안 암전 상태)                  ",
                            "           * 좀비들의 시야가 흐려집니다. 그 틈을 타서 파밍을 합니다!*          ",
                            "           * 단, 파밍을 하는동안 시간은 흐릅니다                              ",
                            "  ======================================================================="};

            for (int i = 0; i < stageInfo.length; i++) {
                System.out.println(stageInfo[i]);
            }

            System.out.println("1. 옆호차 이동 2. 인벤토리 3. 상태확인");
            Scanner scanner = new Scanner(System.in);
            int flag2 = scanner.nextInt();
            switch (flag2) {
                case 1:
                    System.out.println("현재 " + place.trainNum + "호차 입니다. 왼쪽 또는 오른쪽 중 어느쪽으로 넘어가시겠습니까(1,2)");
                    if (scanner.nextInt() == 1) {
                        place.trainNum--;
                        if (place.trainNum == 0) {
                            place.trainNum = 1;
                            System.out.println("1호차가 마지막입니다");
                            System.out.println("1호차에서 6호차 사이로 이동하실 수 있습니다.");
                        }
                    } else if (scanner.nextInt() == 2) {
                        place.trainNum++;
                        if (place.trainNum == 7) {
                            place.trainNum = 6;
                            System.out.println("6호차가 마지막입니다");
                            System.out.println("1호차에서 6호차 사이로 이동하실 수 있습니다.");
                        }
                    }


                    System.out.println(place.trainNum + "호차로 이동합니다.");
                    System.out.println("아이탬을 줏었습니다.");

                    Random random = new Random();
                    if (random.nextBoolean()) {
                        System.out.println("어둠속에서 무기를 얻었습니다.");
                        inventory.setWeaponInventory();
//                        System.out.println(hero.currentWeapon.name + "을(를) 얻었습니다.");
                    } else {
                        System.out.println("어둠속에서 음식을 얻었습니다.");
                        inventory.setFoodInventory();
//                        System.out.println(hero.currentFood.name + "을(를) 얻었습니다.");
                    }
                    break;
                case 2:
                    inventory.showInventory();
                    break;
                case 3:
                    hero.status();
            }
        }

    }
}







//    public void dead(Hero hero){
//        if (hero.stamina<=0){
//            String choiceInfo[] = {
//                    "====================================================================",
//                    "                              게임오바                               ",
//                    "( 좀비들을 제한시간 내에 죽이지 못하여 주인공이 좀비들에게 물려 죽었습니다.)",
//                    "====================================================================="
//            };
//            for (int i = 0; i < choiceInfo.length; i++) {
//                System.out.println(choiceInfo[i]);
//            }
//
//        }
//    }
//public void tunnelOff(){ //터널밖
//    String choiceInfo[] = {
//            "===================================================================",
//            "                         터널 밖으로 나왔습니다                      ",
//            "( 1분 뒤에 터널이 나옵니다. 터널속으로 들어가기전에 좀비들과 싸우십시오.) ",
//            "==================================================================="
//    };
//    for (int i = 0; i < choiceInfo.length; i++) {
//        System.out.println(choiceInfo[i]);
//    }
//}