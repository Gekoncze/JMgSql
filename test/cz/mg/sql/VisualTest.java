package cz.mg.sql;


import cz.mg.sql.block.select.Order;
import cz.mg.sql.data.SqlCreateBuilder;
import cz.mg.sql.data.SqlReadBuilder;


public class VisualTest {
    public static void main(String[] args) {
        SqlCreateBuilder create = new SqlBuilder()
            .create("FooBar")
            .column("foo")
            .column("bar");

        SqlReadBuilder read = new SqlReadBuilder()
            .read("FooBar", "foobar")
            .column("foo", "f")
            .column("bar", "b")
            .column("SUM(price)")
            .column("MAX(price)")
            .join("NoName", "noname", "foobar.n = noname.id")
            .where("f > 1")
            .where("b > 1")
            .groupBy("f, b")
            .having("SUM(price) > 0")
            .orderBy("SUM(price)", Order.ASCENDING)
            .orderBy("MAX(price)", Order.DESCENDING);

        System.out.println(create.build(Formatting.SINGLE_LINE).getText());
        System.out.println("--");
        System.out.println(create.build(Formatting.MULTI_LINE).getText());
        System.out.println("--");

        System.out.println();

        System.out.println(read.build(Formatting.SINGLE_LINE).getText());
        System.out.println("--");
        System.out.println(read.build(Formatting.MULTI_LINE).getText());
        System.out.println("--");
    }
}
