package sample.model.generic;

import java.util.ArrayList;
import java.util.List;

public class SampleGeneric {

	public static void main(String[] args) {

		// Box<String> name = new Box<String>("corn");
		// System.out.println("name:" + name.getData());

		// Box<String> name = new Box<String>("corn");
		// Box<Integer> age = new Box<Integer>(712);
		// System.out.println("name class:" + name.getClass()); //
		// com.qqyumidi.Box
		// System.out.println("age class:" + age.getClass()); //
		// com.qqyumidi.Box
		// System.out.println(name.getClass() == age.getClass()); // true

		Box<String> name = new Box<String>("corn");
		Box<Integer> age = new Box<Integer>(712);
		Box<Number> number = new Box<Number>(314);

		getData(name);
		getData(age);
		getData(number);
		
//		getUpperNumberData(name);    // 1
        getUpperNumberData(age);    // 2
        getUpperNumberData(number); // 3
        
        getLowerNumberData(age);    // 2
        getLowerNumberData(number); // 3
        
        List<String> list = new ArrayList<String>();

	}

	public static void getData(Box<?> data) {
		System.out.println("data :" + data.getData());
	}
	
    public static void getUpperNumberData(Box<? extends Number> data){
        System.out.println("data :" + data.getData());
    }
    
    public static void getLowerNumberData(Box<? super Integer> data){
        System.out.println("data :" + data.getData());
    }

}

class Box<T> {

	private T data;

	public Box() {

	}

	public Box(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

}