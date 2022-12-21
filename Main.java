import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите выражение:");
        String exp = scanner.nextLine();
        String[]data;
        char action;

        if(exp.contains("+")){
            data=exp.split("\\+");
            action='+';
        }
        else if(exp.contains("-")){
            data=exp.split("-");
            action='-';
        }
        else if(exp.contains("*")){
            data=exp.split("\\*");
            action='*';}
        else if(exp.contains("/")){
            data=exp.split("/");
            action='/';}
        else{
            throw new Exception("Ошибка");
        }

        for(int i = 0; i< data.length; i++){
            if (data[i].chars().allMatch(Character::isDigit)){ // если число
                if (Integer.parseInt(data[i]) > 10){
                    throw new Exception("Ошибка число не может быть больше 10ти! {}");
                }
            } else { // если строка
                if (data[i].length() > 10){
                    throw new Exception("Ошибка строка не может быть больше 10ти символов!");
                }
            }

        }
        if(action=='*' || action=='/') {
            if (data[1].contains("\"")) throw new Exception("Ошибка: не верный ввод данных");
        }
        for(int i = 0; i< data.length;i++){
            data[i]=data[i].replace("\"","");
        }
        if(action=='+'){
            printInQuotes(data[0]+data[1]);
        }else if(action=='*'){
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for(int i=0;i<multiplier;i++){
                result+=data[0];
            }

            printInQuotes(result);
        }else if(action=='-'){
            int index = data[0].indexOf(data[1]);
            if(index==-1){
                printInQuotes(data[0]);
            }else{
                String result = data[0].substring(0, index);
                result+=data[0].substring(index+data[1].length());
                printInQuotes(result);
            }

        }else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result =data[0].substring(0, newLen);
            printInQuotes(result);
        }



    }
    static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
    }

}