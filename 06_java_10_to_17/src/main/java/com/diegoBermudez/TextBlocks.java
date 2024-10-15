package com.diegoBermudez;

public class TextBlocks {

    public static void main(String[] args) {
        String hello = """
                hello world
                    I'm juan diego
                        Jjejejeje
                Yeah, so I think that
                """;

        String xml = """
                 <hello>
                        <world></world>
                 </hello>
                """;

        String link = """
                <a href="#"> a link </a>
                you use a text blocks with <code>\"""</code>
                """;

        String veryLongLine = """
                this is a single very long line that I'm writing right here to show you how \
                we can have the single line written in multiple lines in the code so that it \
                is readable and easy to understand, so as you are seeing this is already composed \
                by 4 lines, but when we print it it will be only a single line, lets say that now I \s
                do want that jump, but the rest of the text will continue being a single line as \
                we did with the first line and I think that would be all
                """;

        String name = "Juan diego";
        int age = 20;
        String withVariables= """
                Hello dear %name
                I'm happy to hear that you just celebrated your %age birhtday
                """.replaceAll("%name", name).replaceAll("%age", Integer.toString(age));

        System.out.println(hello);
        System.out.println(xml);
        System.out.println(link);
        System.out.println(veryLongLine);
        System.out.println(withVariables);
    }
}
