package Reflact;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestReflact {

    public static void main(String[] args) throws IOException
    {
        Properties properties = new Properties();
        properties.load(new FileReader("src/Reflact/config.properties"));
        String name = properties.getProperty("name");

        try
        {
            Class c = Class.forName(name);
            Constructor con = c.getConstructor();

            Object aHero = con.newInstance();
            Method m = c.getMethod("attack");
            m.invoke(aHero);

        }catch(Exception e)
        {
            e.printStackTrace();
        }



    }
}
