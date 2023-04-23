import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        MyFriend firstFriend = new MyFriend();
        System.out.print("Расскажите о своем друге: ");
        firstFriend.setInformationAboutMyFriend(sc.nextLine());
        System.out.print("Как зовут Вашего друга: ");
        firstFriend.setNameFriend(sc.nextLine());
        System.out.print("Сколько лет Вашему другу: ");
        boolean flag = true;
        do {
            try {
                if(sc.hasNextInt()) {
                    firstFriend.setAgeFriend(sc.nextInt());
                    if(firstFriend.getAgeFriend() <= 0 || firstFriend.getAgeFriend() > 130)
                        throw new Exception();
                    flag = false;
                }
                else {
                    String temp = sc.next();
                    throw new Exception();
                }
            }
            catch(Exception error) {
                System.out.print("Вы указали некорректный возраст. Желаете повторить попытку (Да/Нет): ");
                String tempFlag = sc.next();
                flag = (tempFlag.equals("Да") || tempFlag.equals("ДА")) ? true : false;
                if(tempFlag.equals("Да") || tempFlag.equals("ДА"))
                    System.out.print("Уточняем возраст друга: ");
            }
        }
        while(flag);
        System.out.printf("Вашего друга зовут %s и ему сейчас %d лет.",
                firstFriend.getNameFriend(), firstFriend.getAgeFriend());
    }
}