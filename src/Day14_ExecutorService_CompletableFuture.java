import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day14_ExecutorService_CompletableFuture {

    static String readFile(String fileName) throws IOException{
        return Files.readString(Path.of(fileName));
    }
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(5);

        CompletableFuture<String> file1=CompletableFuture.supplyAsync(()->{
            try{
                return readFile("file1.txt");
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        },executor).exceptionally(e->"Error Reading file1");

        CompletableFuture<String> file2=CompletableFuture.supplyAsync(()->{
            try{
                return readFile("file2.txt");
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        },executor).exceptionally(e->"Error Reading file2");

        CompletableFuture<String> file3=CompletableFuture.supplyAsync(()->{
            try{
                return readFile("file3.txt");
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        },executor).exceptionally(e->"Error Reading file3");

        CompletableFuture<String> file4=CompletableFuture.supplyAsync(()->{
            try{
                return readFile("file4.txt");
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        },executor).exceptionally(e->"Error Reading file4");

        CompletableFuture<String> file5=CompletableFuture.supplyAsync(()->{
            try{
                return readFile("file5.txt");
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        },executor).exceptionally(e->"Error Reading file5");

        CompletableFuture<String> results=
                file1.thenCombine(file2,(a,b)->a + "\n" + b)
                        .thenCombine(file3,(a,b)->a + "\n" + b)
                        .thenCombine(file4,(a,b)->a + "\n" + b)
                        .thenCombine(file5,(a,b)->a + "\n" + b);

        System.out.println(results.join());

        executor.shutdown();
    }
}
