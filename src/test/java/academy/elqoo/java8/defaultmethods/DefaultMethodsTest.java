package academy.elqoo.java8.defaultmethods;

import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DefaultMethodsTest {

    @Test
    public void shouldMoveShape(){
        Shape shape = new Rectangle();
        // implement a default move method without changing the Rectangle class
        shape.move(10,10);
        assertThat(10, equalTo(shape.getXPos()));
        assertThat(10, equalTo(shape.getYPos()));
    }

    @Test(expected = NotImplementedException.class)
    public void shouldThrowNotImplementedException(){
        // add an optional method to the shape method
        Triangle triangle = new Triangle();
        triangle.notImplementedMethod();
    }

     @Test
    public void shouldReturnNameForTriangle(){
        Shape shape = new Triangle();
        assertThat("Triangle",equalTo(shape.getName()));
    }

     @Test
    public void shouldReturnNameForRectangle(){
        Shape shape = new Rectangle();
        assertThat("Abstract Shape",equalTo(shape.getName()));
    }

    @Test
    public void shouldProvideName(){
        // make rectangle implement NamedObject
        NamedObject namedObject = new Rectangle();
        assertThat("Abstract Shape",equalTo(namedObject.getName()));
    }


}
