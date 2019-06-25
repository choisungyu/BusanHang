import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    ArrayList<Weapon> weaponList;
    ArrayList<Food> foodList;
    Hero hero = Hero.getInstance();


    private static Inventory inventory;

    private Inventory() {
        weaponList = new ArrayList<>();
        foodList = new ArrayList<>();
    }


    public static Inventory getInstance() {
        if (inventory == null) {
            inventory = new Inventory();
        }
        return inventory;
    }
    void setWeaponInventory() {


        ArrayList<Weapon> weaponList = new ArrayList<>();


//        weaponList.add(new Weapon("나무배트", 20, 10));
//        weaponList.add(new Weapon("강철배트", 20, 15));

//        System.out.println(Arrays.toString(weaponList.toArray()));[Weapon@6e0be858, Weapon@61bbe9ba]



        double randomValue = Math.random(); // ( 0~0.1 )*100 = 0~10
        int intRandomValue = (int) (randomValue * 100) +1 ;

            if (intRandomValue >= 1 && intRandomValue <= 20) {

                weaponList.add(0,new Weapon("나무배트", 20, 10));
                for (int i = 0 ; i < weaponList.size() ; i++ ){

                    System.out.println(weaponList.get(i).name);
//                    hero.currentWeapon.name = weaponList.get(i).name;

                    hero.setWeapons(weaponList.get(i));
                }
            }
            else if (intRandomValue >= 21 && intRandomValue <= 40) {
                weaponList.add(new Weapon("강철배트", 20, 10));
                for (int i = 0 ; i < weaponList.size() ; i++ ){

                    System.out.println(weaponList.get(i).name);
                    hero.setWeapons(weaponList.get(i));
                }
            }
            else if (intRandomValue >= 41 && intRandomValue <= 60) {
                weaponList.add(new Weapon("야구공", 20, 15));
                for (int i = 0 ; i < weaponList.size() ; i++ ){

                    System.out.println(weaponList.get(i).name);
                    hero.setWeapons(weaponList.get(i));
                }
            }
            else if (intRandomValue >= 61 && intRandomValue <= 80) {
                weaponList.add(new Weapon("낚싯대", 20, 15));
                for (int i = 0 ; i < weaponList.size() ; i++ ){

                    System.out.println(weaponList.get(i).name);

                    hero.setWeapons(weaponList.get(i));
                }
            }
            else if (intRandomValue >= 81 && intRandomValue <= 100) {
                weaponList.add(new  Weapon("비상용해머", 20, 15));
                for (int i = 0 ; i < weaponList.size() ; i++ ){

                    System.out.println(weaponList.get(i).name);
                    hero.setWeapons(weaponList.get(i));
                }
            }

//            inventory.weaponList = weaponList;
    }


    void setFoodInventory() {
        ArrayList<Food> foodList = new ArrayList<>();
        double randomValue = Math.random();
        int intRandomValue = (int) (randomValue * 100) +1 ;


        if (intRandomValue >= 1 && intRandomValue <= 20) {
            foodList.add(new  Food("물(기본)", 5));

            for (int i = 0 ; i < foodList.size() ; i++ ){

                System.out.println(foodList.get(i).name);
                hero.setFood(foodList.get(i));
            }
        }
        else if (intRandomValue >= 21 && intRandomValue <= 40) {
            foodList.add(new  Food("주먹밥", 6));

            for (int i = 0 ; i < foodList.size() ; i++ ){

                System.out.println(foodList.get(i).name);
                hero.setFood(foodList.get(i));
            }
        }
        else if (intRandomValue >= 41 && intRandomValue <= 60) {
            foodList.add(new  Food("삼각김밥", 7));

            for (int i = 0 ; i < foodList.size() ; i++ ){

                System.out.println(foodList.get(i).name);
                hero.setFood(foodList.get(i));
            }

        }
        else if (intRandomValue >= 61 && intRandomValue <= 80) {
            foodList.add(new Food("계란", 5));

            for (int i = 0 ; i < foodList.size() ; i++ ){

                System.out.println(foodList.get(i).name);
                hero.setFood(foodList.get(i));
            }

        }
        else if (intRandomValue >= 81 && intRandomValue <= 100) {
            foodList.add(new  Food("햄버거", 5));

            for (int i = 0 ; i < foodList.size() ; i++ ){

                System.out.println(foodList.get(i).name);
                hero.setFood(foodList.get(i));
            }
        }

    }


    public void showInventory(){
        if (weaponList.size()==0){
            System.out.println("====================INVENTORY==================");
            System.out.println("    소지한 무기 : 없 음    ");

        }
        else
        {
            for (int i = 0; i < weaponList.size(); i++) {

                System.out.println("====================INVENTORY==================");
                System.out.println("    소지한 무기 : " + weaponList.get(i).name);
            }
        }
        if (foodList.size()==0){
            System.out.println("    소지한 음식 : 없 음    ");
            System.out.println("==============================================");
            }
        else {
            for (int j = 0; j < foodList.size(); j++) {
                System.out.println("    소지한 음식 : " + foodList.get(j).name);
                System.out.println("==============================================");
            }
        }
//        for (int i = 0; i < foodList.size(); i++) {
//
//            System.out.println("====================INVENTORY==================");
//            System.out.println("    소지한 무기 : " + weaponList.get(i).name);
//        }
//        for (int j = 0; j < foodList.size(); j++) {
//            System.out.println("    소지한 음식 : " + foodList.get(j).name);
//            System.out.println("==============================================");
//        }
        useInventory();

    }



    public void useInventory() {

        System.out.println("무엇을 사용하시겠습니까");
        System.out.println("1.무기    2.음식    3.돌아가기");
        Scanner scanner = new Scanner(System.in);
        int flag1 = scanner.nextInt();

        switch (flag1) {
            case 1: // 무기선택
                for (int i = 0; i < weaponList.size(); i++) {
                        if (weaponList.get(i).name==null){
                            System.out.println("사용할 무기가 없습니다.");
                            showInventory();

                        }

                }


                System.out.println("어떠한 무기를 선택하시겠습니까");
                String weaponChoice = scanner.next();
                System.out.println(weaponChoice + "을(를) 선택하셨습니다.");
                for (int i = 0; i < weaponList.size(); i++) {
                    if (weaponList.get(i).name.equals(weaponChoice)) {
                        System.out.println(weaponChoice + "을(를) 사용하였습니다.");
                        weaponList.remove(weaponChoice);
                        hero.setWeapons(weaponList.get(i));
//                                hero.setWeapons(hero.currentWeapon);

                    } else {
                        System.out.println(weaponChoice + "는(은) 목록에 없습니다..");
                    }

                }
                break;

            case 2: // 음식선택
                System.out.println("어떠한 음식을 선택하시겠습니까");
                String foodChoice = scanner.next();

                System.out.println(foodChoice + "을(를) 선택하셨습니다.");
                for (int i = 0; i < foodList.size(); i++) {
                    if (foodList.get(i).name.equals(foodChoice)) {
                        System.out.println(hero.getFood() + "을(를) 사용하였습니다.");
                        foodList.remove(foodList.get(i));
                        hero.setFood(foodList.get(i));
                        System.out.println("채력이" + hero.currentFood.stamina + "만큼 올랐습니다. 스테미나 : " + hero.stamina);
                    } else {
                        System.out.println(foodChoice + "는(은) 목록에 없습니다..");
                    }

                }
                break;

            case 3:

                return;
        }
    }



}





//else if (intRandomValue >= 81 && intRandomValue <= 100) {
//        Food food5 = new Food("햄버거", 5);
//        foodList.add(food5);
//        for (int i = 0 ; i < foodList.size() ; i++ ){
//
//        System.out.println(foodList.get(i));
//
//        }
//        System.out.println(foodList.add(food5));
//
//        hero.currentFood.name= food5.name;
//
//        System.out.println(hero.currentFood.name);
//        }