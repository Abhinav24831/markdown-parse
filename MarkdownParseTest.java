import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void links() throws IOException{
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://something.com");
        output.add("some-page.html");
        
        assertEquals(output, links);
    }

    @Test
    public void links2() throws IOException{
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-file2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://something.com");
                
        assertEquals(output, links);
    }

    @Test
    public void links3() throws IOException{
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://something.com");
        
        assertEquals(output, links);
    }

    @Test
    public void links4() throws IOException{
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-file3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://something.com");
        
        assertEquals(output, links);
    }

    @Test
    public void testSnippet1() throws IOException{
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-snippet-1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("`google.com");
        output.add("google.com");
        output.add("ucsd.edu");

        assertEquals(output, links);
    }

    @Test
    public void testSnippet2() throws IOException{
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-snippet-2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("a.com");
        output.add("a.com(())");
        output.add("example.com");

        assertEquals(output, links);
    }

    @Test
    public void testSnippet3() throws IOException{
        ArrayList<String> output = new ArrayList<>();
        Path fileName = Path.of("test-snippet-3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        output.add("https://www.twitter.com");
        output.add("https://ucsd-cse15l-w22.github.io/");
        output.add("https://cse.ucsd.edu/");

        assertEquals(output, links);
    }


}