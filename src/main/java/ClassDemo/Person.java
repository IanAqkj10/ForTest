package ClassDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:IanJ
 * @date:2021/7/3 21:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    //xxxxxx
    private String name;
    private Integer age;
    private Date date;
    private Long qaq;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age,Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }


    @Override
    public String toString() {
        return "ClassDemo.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", qaq=" + qaq +
                '}';
    }
}