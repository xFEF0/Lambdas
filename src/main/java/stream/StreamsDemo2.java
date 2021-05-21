package stream;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo2 {

    public static void main(String[] args) throws IOException {
        System.out.println("==== buildStream demo ====");
        Stream<String> streamFromValues = Stream.of("one", "two", "three");
        System.out.println("streamFromValues = " + streamFromValues.collect(Collectors.toList()));

        String[] array = {"one", "two", "three"};
        Stream<String> streamFromArray1 = Arrays.stream(array);
        System.out.println("streamFromArray1 = " + streamFromArray1.collect(Collectors.toList()));
        Stream<String> streamFromArray2 = Stream.of(array);
        System.out.println("streamFromArray2 = " + streamFromArray2.collect(Collectors.toList()));

        File file = new File("1.tmp");
        file.deleteOnExit();
        PrintWriter out = new PrintWriter(file);
        out.println("one");
        out.println("two");
        out.println("three");
        out.close();
        Stream<String> streamFromFiles = Files.lines(Paths.get(file.getAbsolutePath()));
        System.out.println("streamFromFiles = " + streamFromFiles.collect(Collectors.toList()));

        Collection<String> collection = Arrays.asList("one", "two", "three");
        Stream<String> streamFromCollection = collection.stream();
        System.out.println("streamFromCollection = " + streamFromCollection.collect(Collectors.toList()));

        IntStream streamFromString = "123".chars();
        System.out.print("streamFromString = ");
        streamFromString.forEach(e -> System.out.print(e + ", "));
        System.out.println();

        Stream.Builder<String> builder = Stream.builder();
        Stream<String> streamFromBuilder = builder.add("one")
                .add("two")
                .add("three")
                .build();
        System.out.println("streamFromBuilder = " + streamFromBuilder.collect(Collectors.toList()));

        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 2);
        System.out.println("streamFromIterate = " + streamFromIterate.limit(3).collect(Collectors.toList()));

        Stream<String> streamFromGenerate = Stream.generate(() -> "one");
        System.out.println("streamFromGenerate = " + streamFromGenerate.limit(3).collect(Collectors.toList()));

        Stream<String> streamEmpty = Stream.empty();
        System.out.println("streamEmpty = " + streamEmpty.collect(Collectors.toList()));

        Stream<String> parallelStream = collection.parallelStream();
        System.out.println("parallelStream = " + parallelStream.collect(Collectors.toList()));
    }
}
