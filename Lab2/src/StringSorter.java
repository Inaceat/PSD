import java.util.Arrays;

public class StringSorter
{

    public static void main(String[] args)
    {
        var arr = args.clone();

        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());

        System.out.println("Sort by length:");

        for (var s : arr)
            System.out.println("  " + s);

        //Arrays.sort(arr, (o1, o2) -> o1.c);

        System.out.println("Sort by lower-case letters count:");

        for (var s : arr)
            System.out.println("  " + s);
    }
}
