package academy.elqoo.java8.defaultmethods;

import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface Shape {

    int getXPos();

    int getYPos();

    void setXPos(int xPOs);

    void setYPos(int yPos);

    default String getName(){
        return "";
    }
    
    default void move(final int side1Extension, final int side2Extension) {
    	setXPos(getXPos()+side1Extension);
    	setYPos(getYPos()+side1Extension);
    }

	static void moveXPosWith10(List<AbstractShape> shapes) {
		for (AbstractShape abstractShape : shapes) {
			abstractShape.setXPos((abstractShape.getXPos()+10));
		}
	}
	
	default void notImplementedMethod() {
		throw new NotImplementedException();
	}


}
