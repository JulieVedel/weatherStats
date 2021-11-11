package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] day2011 = new String[31];
        double[] rain2011 = new double[31];
        readFromTxt(day2011, rain2011, "rain2011.txt");

        String[] day2020 = new String[31];
        double[] rain2020 = new double[31];
        readFromTxt(day2020, rain2020, "rain2020.txt");

        double[] temp2011 = new double[31];
        readFromTxt(day2011, temp2011, "temp2011.txt");

        double[] temp2020 = new double[31];
        readFromTxt(day2020, temp2020, "temp2020.txt");

//      Assignment 1.
        double[] averageTemp = averageTemp(temp2011, temp2020);
        double averageTemp2011 = averageTemp[0];
        double averageTemp2020 = averageTemp[1];
//      Assignment 2.
        double[] averageRain = averageRain(rain2011, rain2020);
        double averageRain2011 = averageRain[0];
        double averageRain2020 = averageRain[1];
//      Assignment 3.
//        tempStats(temp2011, temp2020);
//      Assignment 4.
//        highestAndLowest(temp2011, temp2020);
//      Assignment 5.
//        higherThanAverage(temp2011, averageTemp2011);
//      Assignment 6.
//        rainyDays(rain2011, day2011, rain2020, day2020);
//      Assignment 7.
//        lowerThanAverageRain(rain2020, averageRain2020);
//      Assignment 9.
//        tempHigherIn2020(temp2011, day2011, temp2020, day2020);
//      Assignment 10.
//        between4and6(temp2020);
//      Assignment 11.
//        sortTemp(temp2011);

    }

    public static void readFromTxt(String[] day, double[] weather, String filePath) {
        int i = 0;
        try {
            File out = new File(filePath);
            Scanner scanner = new Scanner(out);
            while(scanner.hasNext()) {
                day[i] = scanner.next();
                weather[i] = scanner.nextDouble();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static double round(double value) {
        value = Math.round(value * 100d) / 100d;
        return value;
    }

    public static double[] averageTemp(double[] temp2011, double[] temp2020) {
        double averageTemp2011 = 0;
        double averageTemp2020 = 0;

        for (int i = 0; i < temp2011.length; i++) {
            averageTemp2011 += temp2011[i];
            averageTemp2020 += temp2020[i];
        }
        averageTemp2011 /= (temp2011.length);
//        System.out.println("The average temperature in January 2011 was " + round(averageTemp2011) + " degrees.");
        averageTemp2020 /= temp2020.length;
//        System.out.println("The average temperature in January 2020 was " + round(averageTemp2020) + " degrees.");

//        if (averageTemp2011 > averageTemp2020) {
//            System.out.println("The average temperature was higher in January 2011 than in January 2020.\n");
//        } else if (averageTemp2011 < averageTemp2020) {
//            System.out.println("The average temperature was lower in January 2011 than in January 2020.\n");
//        }
        return new double[] {averageTemp2011, averageTemp2020};
    }

    public static double[] averageRain(double[] rain2011, double[] rain2020) {
        double averageRain2011 = 0;
        double averageRain2020 = 0;

        for (int i = 0; i < rain2011.length; i++) {
            averageRain2011 += rain2011[i];
            averageRain2020 += rain2020[i];
        }
        averageRain2011 /= (rain2011.length);
//        System.out.println("The average rain pr day in January 2011 was " + round(averageRain2011) + " mm.");
        averageRain2020 /= rain2020.length;
//        System.out.println("The average rain pr day in January 2020 was " + round(averageRain2020) + " mm.");

//        if (averageRain2011 > averageRain2020) {
//            System.out.println("The average rain pr day was higher in January 2011 than in January 2020.\n");
//        } else if (averageRain2011 < averageRain2020) {
//            System.out.println("The average rain pr day was lower in January 2011 than in January 2020.\n");
//        }
        return new double[] {averageRain2011, averageRain2020};
    }

    public static void tempStats(double[] temp2011, double[] temp2020) {
        int over0for2011 = 0;
        int is0for2011 = 0;
        int under0for2011 = 0;
        int over0for2020 = 0;
        int is0for2020 = 0;
        int under0for2020 = 0;

        for (int i = 0; i < temp2011.length; i++) {
            if (temp2011[i] > 0) {
                over0for2011++;
            } else if (temp2011[i] == 0) {
                is0for2011++;
            } else if (temp2011[i] < 0) {
                under0for2011++;
            }

            if (temp2020[i] > 0) {
                over0for2020++;
            } else if (temp2020[i] == 0) {
                is0for2020++;
            } else if (temp2020[i] < 0) {
                under0for2020++;
            }

        }
        System.out.println("Statistics for temperature of January 2011:\n" +
                "Days with over 0 degrees: " + over0for2011 + " days.\n" +
                "Days with 0 degrees: " + is0for2011 + " days.\n" +
                "Days with less than 0 degrees: " + under0for2011 + " days.\n" );
        System.out.println("Statistics for temperature of January 2020:\n" +
                "Days with over 0 degrees: " + over0for2020 + " days.\n" +
                "Days with 0 degrees: " + is0for2020 + " days.\n" +
                "Days with less than 0 degrees: " + under0for2020 + " days.\n" );
    }

    public static void highestAndLowest(double[] temp2011, double[] temp2020) {
        double highest2011 = temp2011[0];
        double lowest2011 = temp2011[0];
        double highest2020 = temp2020[0];
        double lowest2020 = temp2020[0];

        for (int i = 0; i < temp2011.length; i++) {
            if (temp2011[i] > highest2011) {
                highest2011 = temp2011[i];
            }
            if (temp2011[i] < lowest2011) {
                lowest2011 = temp2011[i];
            }
            if (temp2020[i] > highest2020) {
                highest2020 = temp2020[i];
            }
            if (temp2020[i] < lowest2020) {
                lowest2020 = temp2020[i];
            }
        }
        System.out.println("The highest temperature in January 2011 was " + highest2011 + " degrees.");
        System.out.println("The lowest temperature in January 2011 was " + lowest2011 + " degrees.\n");
        System.out.println("The highest temperature in January 2020 was " + highest2020 + " degrees.");
        System.out.println("The lowest temperature in January 2020 was " + lowest2020 + " degrees.\n");
    }

    public static void higherThanAverage(double[] temp2011, double averageTemp2011) {
        int count = 0;
        for (int i = 0; i < temp2011.length; i++) {
            if (temp2011[i] > averageTemp2011) {
                count++;
            }
        }
        System.out.println("In January 2011, there was " + count +
                " days where the temperature was higher than the average of that month.\n");
    }

    public static void rainyDays(double[] rain2011, String[] dates2011, double[] rain2020, String[] dates2020) {
        String[] didRain2011 = new String[31];
        String[] didRain2020 = new String[31];

        for (int i = 0; i < rain2011.length; i++) {
            if (rain2011[i] > 0) {
                didRain2011[i] = dates2011[i];
            }
            if (rain2020[i] > 0) {
                didRain2020[i] = dates2020[i];
            }
        }
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < didRain2011.length; i++) {
            if (didRain2011[i] == null) {
                count1++;
            }
            if (didRain2020[i] == null) {
                count2++;
            }
        }
        String[] array1 = new String[didRain2011.length - count1];
        String[] array2 = new String[didRain2020.length - count2];
        int j = 0;
        int k = 0;
        for (int i = 0; i < didRain2011.length; i++) {
            if (didRain2011[i] != null) {
                array1[j] = didRain2011[i];
                j++;
            }
            if (didRain2020[i] != null) {
                array2[k] = didRain2020[i];
                k++;
            }
        }
        System.out.println("The following array shows a list of dates where it rained in January 2011: ");
        System.out.println(Arrays.toString(array1) + "\n");
        System.out.println("The following array shows a list of dates where it rained in January 2020: ");
        System.out.println(Arrays.toString(array2) + "\n");
    }

    public static void lowerThanAverageRain(double[] rain2020, double averageRain2020) {
        int count = 0;
        for (int i = 0; i < rain2020.length; i++) {
            if (rain2020[i] < averageRain2020) {
                count++;
            }
        }
        System.out.println("In January 2020, there was " + count +
                " days where it rained more than the average of that month.\n");
    }

    public static void tempHigherIn2020(double[] temp2011, String[] dates2011, double[] temp2020, String[] dates2020) {
        String[] wasHigherIn2020 = new String[temp2011.length];
        for (int i = 0; i < temp2011.length; i++) {
            if (temp2020[i] > temp2011[i]) {
                wasHigherIn2020[i] = dates2020[i];
            }
        }
        int count = 0;
        for (int i = 0; i < wasHigherIn2020.length; i++) {
            if (wasHigherIn2020[i] == null) {
                count++;
            }
        }
        String[] array = new String[wasHigherIn2020.length - count];
        int j = 0;
        for (int i = 0; i < wasHigherIn2020.length; i++) {
            if (wasHigherIn2020[i] != null) {
                array[j] = wasHigherIn2020[i];
                j++;
            }
        }
        System.out.println("The following array shows a list of dates where the temperature was higher in January 2020 in comparison to January 2011: ");
        System.out.println(Arrays.toString(array));
    }

    public static void between4and6(double[] temp2020) {
        int count = 0;
        for (int i = 0; i < temp2020.length; i++) {
            if (temp2020[i] > 4 && temp2020[i] <= 6) {
                count++;
            }
        }
        System.out.println("The amount of days where the temperature in January 2020 " +
                "was higher than 4 degrees and less than/equal to 6 degrees: " + count);

    }

    public static void sortTemp(double[] temp2011) {
        Arrays.sort(temp2011);
        System.out.println("The following array is a list of temperatures that was measured throughout January 2011. " +
                "They are sorted from lowest to highest temperature: ");
        System.out.println(Arrays.toString(temp2011));
        System.out.println("The median of this array is: " + temp2011[temp2011.length / 2]);
    }
}

