package eg.edu.alexu.csd.oop.calculator.cs59;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

public class Operations implements Calculator {

    private String word; private ArrayList<String> storage = new ArrayList<>(100); int counter=-1;
    private ArrayList<String> results = new ArrayList<>(100);

    public void input(String s) {

        Pattern p = Pattern.compile("^(-?\\d+\\.?\\d*)([\\*\\-\\+\\/])(-?\\d+\\.?\\d*)$");

        Matcher m = p.matcher(s);

        if (m.matches()) {

            String[] split = new String[3];

            for (int i = 0; i < 3; i++) {

                split[i] = m.group(i+1);

            }

            Double num1, num2, ans=0.0;

            num1 = Double.parseDouble(split[0]); num2 = Double.parseDouble(split[2]);

            switch (split[1].charAt(0)) {

                case '+': ans = num1 + num2; break;

                case '-': ans = num1 - num2; break;

                case '*': ans = num1 * num2; break;

                case '/': ans = num1 / num2; break;

            }

            if (Double.isInfinite(ans)) word = null;
            else {

                word = ans.toString(); storage.add(s); counter = storage.size()-1;
                results.add(word);

            }

        } else if (Pattern.matches("^-?\\d+\\.?\\d*$",s)) {

            word = s; storage.add(s); counter = storage.size()-1;
            results.add(word);

        } else {

            word = null;

        }

    }

    public String getResult() {

        return word;

    }

    public String current () {

        if (counter  > -1) {

            word = results.get(counter);
            return storage.get(counter);

        }
        else return null;

    }

    public String prev() {

        if (counter-1 > -1 && storage.size()-6 < counter-1) {

            counter--;
            word = results.get(counter);
            return storage.get(counter);

        } else return null;

    }

    public String next() {

        if (counter+1 < storage.size()) {

            counter++;
            word = results.get(counter);
            return storage.get(counter);

        } else return null;

    }

    public void save() {

        try {

            File file = new File("memory.txt");
            PrintWriter input = new PrintWriter(file);
            if (!file.exists()) file.createNewFile();

            input.println(Integer.toString(counter));
            for (int i = 0; i < storage.size(); i++) {

                input.println(storage.get(i)); input.println(results.get(i));

            }

            input.close();

        }catch (Exception e) {

            word = "error";

        }

    }

    public void load() {

        try {

            BufferedReader output = new BufferedReader(new FileReader("memory.txt"));
            String line; storage.clear(); results.clear();

            counter=Integer.parseInt(output.readLine());
            while ((line = output.readLine()) != null) {

                storage.add(line); line = output.readLine(); results.add(line);

            }

            output.close();

        } catch (Exception e) {

            word = "error";

        }


    }

}
