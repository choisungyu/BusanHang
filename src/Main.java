import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;

public class Main {


    private static int zombieIndex = 0;
//    private static Boolean isTunnelOn = true;
//    private static Boolean isTunnelOff = true;


    public static void main(String args[]) {


        Inventory inventory = Inventory.getInstance(); // inventory객체
        Place place = Place.getInstance(); // FirstRunnable
        Tunnel tunnel = Tunnel.getInstance();


        Hero hero = new Hero("윤상화(마동석)", 3, 100, new Weapon(" 주먹(기본무기)", 0, 3), "서울역", new Food("없음", 0));


        Zombie zombie1 = new Zombie("서울역좀비", 30, 8, 1);
        Zombie zombie2 = new Zombie("천안아산역좀비", 40, 10, 1);
        Zombie zombie3 = new Zombie("대전역좀비", 50, 10, 1);
        Zombie zombie4 = new Zombie("동대구역좀비", 60, 10, 1);
        Zombie zombie5 = new Zombie("부산역좀비", 70, 10, 1);


        ArrayList<Zombie> zombieList = new ArrayList<>();

        zombieList.add(zombie1);
        zombieList.add(zombie2);
        zombieList.add(zombie3);
        zombieList.add(zombie4);
        zombieList.add(zombie5);


        String stage1startInfo[] = {
                "==================================================================",
                "                        STAGE 1 서 울 역 START                     ",
                "=================================================================="
        };
        for (int i = 0; i < stage1startInfo.length; i++) {
            System.out.println(stage1startInfo[i]);
        }


        while (true) {
            String choiceInfo[] = {
                    "===================================================================",
                    "   1. 게임설명   2. 상태확인   3. 인벤토리   4. 결투   5. 게임 나가기  ",
                    "==================================================================="};
            for (int k = 0; k < choiceInfo.length; k++) {
                System.out.println(choiceInfo[k]);
            }
            System.out.println("번호를 눌러주세요.");
            Scanner scan = new Scanner(System.in);
            int flag = scan.nextInt();
            switch (flag) {
                case 1: // 게임설명
                    FileReader.file2();
                    break;
                case 2:// 상태
                    hero.status();
                    break;
                case 3: // 인벤토리
                    inventory.showInventory();
                    break;

                case 4: // 전투
                    //전투 시작하자마자 5분 시작
                    Zombie currentZombie = zombieList.get(zombieIndex);
                    hero.attack(zombieList.get(zombieIndex));

                    System.out.println("좀비가 어느샌가 " + currentZombie.zombieNum + "마리가 되었습니다.");
                    // 서울좀비로 계속 해놓으면 안됨 바꿔줘야 함
                    System.out.println("제한시간은 5분30초"); // 쓰레드 5분 마춰놔야함
                    System.out.print("\n");

                    System.out.println("전투시작");
                        for (int i = 0; i < 20; i++) {
                            System.out.print("▶");
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }


                    System.out.print("\n");
                    System.out.println(currentZombie.name + currentZombie.countZombieNum + "이(가) 돌진합니다."); //


                    // 터널 밖
                    while (true) {
                        System.out.println("1. 공격 2. 인벤토리 3. 상태확인 4. 터널로 들어가기");
                        Scanner scanner = new Scanner(System.in);
                        int choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1:

                                hero.attack(zombieList.get(zombieIndex));

                                System.out.println(hero.name + "가" + hero.getWeapon().name + "(으)로 내리쳤습니다!");
                                System.out.print("\n");
                                System.out.println("[ 무기 내구도 : " + hero.currentWeapon.durability + "/30 ]");
                                currentZombie.hp -= hero.currentWeapon.weaponOffensePow;
                                hero.stamina -= 5;
                                System.out.println("[ 주인공 스태미너 : " + hero.stamina + "/100 ]");
                                System.out.println("[ " + currentZombie.name + currentZombie.countZombieNum + "의 Hp :" + currentZombie.hp + " :/ 8 ]");
                                System.out.print("\n");

                                if (currentZombie.hp <= 0) {
                                    System.out.println("꽥!...." + currentZombie.name + currentZombie.countZombieNum + "가 쓰러졌습니다.");
                                    System.out.print("\n");

                                    System.out.println(currentZombie.name + currentZombie.countZombieNum + "가 죽었습니다.");
                                    currentZombie.hp = 10;
                                    currentZombie.countZombieNum++;
                                } else {
                                    System.out.println("죽지 않은 " + currentZombie.name + currentZombie.countZombieNum + "가 다시 돌진합니다!");
                                }

                                System.out.println(currentZombie.name + currentZombie.countZombieNum + "가 돌진합니다!");
                                System.out.print("\n");
                                if (currentZombie.countZombieNum == currentZombie.zombieNum) {
                                    System.out.println("모든좀비를 죽였습니다.");
                                    ++zombieIndex;
                                }
                                if (hero.stamina<=10){
                                    System.out.println("크억...체력이 얼마 없어...음식으로 체력을 보충해야 돼");
                                }

                                else if (hero.stamina <= 0) {
                                    System.out.println("크억...");
                                    System.out.println(hero.name+"의 스테미너가 모두 소진되었습니다....");
                                    System.out.println("게임이 종료되었습니다.");
                                    return;
                                }
                                break;
                            case 2:
                                inventory.showInventory();
                                break;
                            case 3:
                                hero.status();
                                break;
                            case 4:
                                tunnel.farming();
                                break;
                        }
                    }

                case 5:
                    System.out.println("게임을 종료합니다.");
                    return;
            }

        }

    }
}










