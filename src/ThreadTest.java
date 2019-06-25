public class ThreadTest extends Thread {



    public void ThreadTest(){
        String importantInfo[] = {
                "[안내] 05시 30분에 부산으로 출발하는 ktx 406열차 출발합니다.",
                "\n" + "잠깐 !!! ",
                "\n" + "갑자기 이상한 여자가 탑승한다.",
                "\n" + "시민 : 저기요.. 이상한 사람이 한 명 탄거 같은데요?",
                "\n" + "승무원 : 네, 손님. 제가 한 번 체크해 보겠습니다. ",
                "\n" + "승무원은 손님이 가르킨 곳으로 향한다. 그곳엔 그 손님이 말한대로 상태가 안 좋아보이는 승객이 쓰러져있다.",
                "\n" + "승무원 : 괜찮으세요 손님?!!! 으악!!!!!!!!"
        };
        for (int i = 0; i < importantInfo.length; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(importantInfo[i]);
        }
    }
}




