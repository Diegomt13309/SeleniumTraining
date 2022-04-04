package section14;


import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class streams {

    @Test
    public void regular(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Alejandra");
        names.add("Don");
        names.add("America");
        names.add("Xian");
        names.add("Adam");
        int count = 0;
        for(int i = 0; i<names.size(); i++){
            String actual = names.get(i);
            if(actual.startsWith("A")){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void streamFilter(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Alejandra");
        names.add("Don");
        names.add("America");
        names.add("Xian");
        names.add("Adam");

        long f = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(f);

        long d = Stream.of("Alejandra","Don","America","Xian","Adam").filter(s->{
                s.startsWith("A");
                return true;
        }).count();
        System.out.println(d);

        System.out.println("---All possibles---");
        names.stream().filter(s->s.length()>4).forEach(System.out::println);
        System.out.println("---One Possible Limit---");
        names.stream().filter(s->s.length()>4).limit(1).forEach(System.out::println);
        System.out.println("---All names---");
        names.forEach(System.out::println);





    }

    @Test
    public void streamMap(){
        ArrayList<String> names = new ArrayList<>();
        names.add("Alejandra");
        names.add("Don");
        names.add("America");
        names.add("Xian");
        names.add("Adam");

        Stream.of("Alejandra","Don","America","Xian","Adam").filter(s->s.endsWith("a")).map(String::toUpperCase).forEach(System.out::println);
        System.out.println("=--------------------------=");
        Stream.of("Alejandra","Don","America","Xian","Adam").filter(s->s.startsWith("A")).sorted().map(String::toUpperCase).forEach(System.out::println);

        List<String> names1 = Arrays.asList("Alejandra","Don","America","Xian","Adam");
        names1.stream().filter(s->s.startsWith("A")).sorted().map(String::toUpperCase).forEach(System.out::println);
        //Concat
        Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Ad77am"));
        System.out.println(flag);
        //Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect(){
        List<String> newListC = Stream.of("Alejandra","Don","America","Xian","Adam").filter(s->s.endsWith("a")).map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(newListC.get(0));

        List<Integer> intList = Arrays.asList(3,2,2,7,5,1,9,7);
        List<Integer> li = intList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("Third number:-> "+li.get(2));
    }

}