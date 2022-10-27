package ClassDemo;

import java.util.ArrayList;
import java.util.List;

public class NameList
{
    private List names = new ArrayList();
    public synchronized void add(String name)
    {
        names.add(name);
    }
    public synchronized void printAll() {
        for (int i = 0; i < names.size(); i++)
        {
            System.out.print(names.get(i) + "");
        }
    }
 

}