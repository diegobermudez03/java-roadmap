package com.diegoBermudez.switchExpression;

public class SwitchExpression {
    public static void main(String[] args) {
        String day = "Saturday";

        //old way
        switch(day){
            case "Saturday", "Sunday":
                System.out.println("alarm at 8am");
                break;
            case "Monday":
                System.out.println("6am");
                break;
            default:
                System.out.println("7am");
        }

        //new way, no breaks, more readable
        switch(day){
            case "Saturday", "Sunday"->  System.out.println("alarm at 8am");
            case "Monday"->System.out.println("6am");
            default->System.out.println("7am");
        }
        switch(day){
            case "Saturday", "Sunday"-> {
                System.out.println("beginning calculation from switch 3");
                System.out.println("alarm at 8am");
            }
            case "Monday"->System.out.println("6am");
            default->System.out.println("7am");
        }

        //SWITCH EXPRESSION, RETURNS A VALUE
        int hour = switch(day){
            case "Saturday", "Sunday"->  {
                System.out.println("checking if I can perform calculations");
                yield 8;
            }
            case "Monday"->6;
            default->7;
        };
        System.out.println(hour);
        System.out.println(calculateHour(day));
    }

    private static int calculateHour(String day){
        //if we don't want to use arrow ->, but : , then is mandatory to use yield keyword as the return
        return switch(day){
            case "Saturday", "Sunday":
                System.out.println("checking if I can perform calculations");
                yield 8;

            case "Monday":yield 6;
            default:yield 7;
        };
    }
}
