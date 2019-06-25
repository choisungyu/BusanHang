import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Hero {

    private static Hero hero ;

    private Hero() {

    }


    public static Hero getInstance() {
        if (hero == null) {
            hero = new Hero();
        }
        return hero;
    }

    public String name;
    int stamina,str;
    String trainStationName;
    Weapon currentWeapon;
    Food currentFood;


    public Hero(String name,int str, int stamina,Weapon currentWeapon,String trainStationName,Food currentFood){
        this.name=name;
        this.stamina = stamina;
        this.trainStationName = trainStationName;

        this.str = str;
        this.currentWeapon = currentWeapon;
        this.currentFood = currentFood;
    }



    public void setWeapons(Weapon currentWeapon){
        str = 0;
        str += currentWeapon.weaponOffensePow;
        System.out.println(hero.name +" 이가 "+currentWeapon.name+" 을 착용합니다.");
        System.out.println("현재 공격력: "+str);
//        hero.currentWeapon.name = currentWeapon.name;


    }

    public Weapon getWeapon() {
        return currentWeapon;
    }

    public void setFood(Food currentFood){
        stamina =100;
        stamina += currentFood.stamina;
        System.out.println(hero.name+"이가" + currentFood.name+" 을 먹었습니다.");
//        hero.currentFood.name = currentFood.name;
    }

    public Food getFood() {
        return currentFood;
    }

    public void attack(Zombie zombie){
        // 공격을 하면 좀비체력 = 좀비체력 - 무기공격력 / 주인공 스테미나 = 스테미나 - 2 / 무기의 내구도 - 2
        if (Objects.equals(zombie.name, "서울역좀비")){
            if (zombie.hp <=0){
                if (zombie.countZombieNum<30){
                    zombie.hp=5;
                }
            }
            if (currentWeapon.durability!=0) {
                currentWeapon.durability -= 2;
            }


        }
        else if (Objects.equals(zombie.name, "천안아산역좀비")) {
            zombie.hp -= currentWeapon.weaponOffensePow;
            stamina = stamina - 2;
            currentWeapon.durability = currentWeapon.durability - 2;
        }
        else if (Objects.equals(zombie.name, "대전역좀비")) {
            zombie.hp -= currentWeapon.weaponOffensePow;
            stamina = stamina - 2;
            currentWeapon.durability = currentWeapon.durability - 3;
        }
        else if (Objects.equals(zombie.name, "동대구역좀비")) {
            zombie.hp -= currentWeapon.weaponOffensePow;
            stamina = stamina - 2;
            currentWeapon.durability = currentWeapon.durability - 4;
        }
        else if (Objects.equals(zombie.name, "부산역좀비")){
            zombie.hp -= currentWeapon.weaponOffensePow;
            stamina = stamina-2;
            currentWeapon.durability = currentWeapon.durability -4;
        }
    }
    

    public void status(){
        while (true){

            System.out.println("============[상태]============");
            System.out.println("주인공 : "+ name);
            System.out.println("스테미나 : " + stamina +"/100");
            System.out.println("공격력 : "+ str);// 랜덤추출한 이름들을 list에 저장해야 함

              //현재 착용한 무기의 공격력이여야 함

            System.out.println("착용한 무기 : " + currentWeapon.name);
            System.out.println("현재 위치한 역 : " + trainStationName);
            System.out.println("상태 창에서 나가시겠습니까? (y,n)");
            System.out.println("=============================");


                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice.equals("y")){// 다시 선택창으로 가야함
                    return;
                }else if (choice.equals("n")){ // no이면 상태창 계속
                    return;


                }else{
                    System.out.println("다시입력하시오");
                    return;
                }


        }

    }



}
