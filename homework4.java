/*1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате 
"Иванов И.И. 32 М"
3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
4.Отсортировать по возрасту используя дополнительный список индексов. */



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class homework4 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
        
        FileWriter fileWriter = null;
        FileReader reader = null;
        try {
            fileWriter = new FileWriter("db.sql");
            fileWriter.append("Привет, Мир!");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        String text = "";
        try {
            reader = new FileReader("db.sql");
            
            while (reader.ready()){
                text += (char)reader.read();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(text);


        /*Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате 
        "Иванов И.И. 32 М"*/

        String text1 = "";
        try {
            reader = new FileReader("db1.sql");
            while (reader.ready()){
                text1 += (char)reader.read();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        List<String> stringList = List.of(text1.split("\n"));

        System.out.println(text1);



        // Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.

        String[] tempString = new String[5];

        LinkedList<String> surname = new LinkedList<>();
        LinkedList<String> name = new LinkedList<>();
        LinkedList<String> secName = new LinkedList<>();
        LinkedList<Integer> age = new LinkedList<>();
        LinkedList<String> sex = new LinkedList<>();

        for (int i = 0; i < stringList.size(); i++) {
            tempString = stringList.get(i).split(" ");
            surname.add(tempString[0]);
            name.add(tempString[1]);
            secName.add(tempString[2]);
            int ageInt = Integer.parseInt(tempString[3]);
            age.add(ageInt);
            sex.add(tempString[4]);
        }

        System.out.println(surname);
        System.out.println(name);
        System.out.println(secName);
        System.out.println(age);
        System.out.println(sex);




        // Отсортировать по возрасту используя дополнительный список индексов.

        List index = new ArrayList();

        int count = 0;
        for (int q = 0; q < age.size(); q++){
            int minAge = 100;
            for (int i = 0; i < age.size(); i++ ) {
                if (minAge > age.get(i)) {
                    minAge = age.get(i);
                    count = i;
                    }
            }
            index.add(count);
            int r = minAge + 100;
            age.set(count, r);
            }
        System.out.println(index);


    }
    
}
