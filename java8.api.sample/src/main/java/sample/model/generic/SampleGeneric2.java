package sample.model.generic;

import java.util.Random;

public class SampleGeneric2 {
	
	public static void main(String...strings) {
		genericClass();
		genericInterface();
		genericMethod();
	}
	


	public static void genericMethod() {
        out("findingsea");
        out(123);
        out(11.11);
        out(true);
        out("findingsea", 123, 11.11, true);
	}
    public static <T> void out(T t) {
        System.out.println(t);
    }
    public static <T> void out(T...ts) {
    	for (T t : ts) {
    		out(t);
    	}
    }


	public static void genericInterface() {
        FruitGenerator generator = new FruitGenerator();
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
        System.out.println(generator.next());
	}
	static class FruitGenerator implements Generator<String> {
	    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};
	    @Override
	    public String next() {
	        Random rand = new Random();
	        return fruits[rand.nextInt(3)];
	    }
	}
	
	interface Generator<T> {
	    public T next();
	}
	
	public static void genericClass() {
        Container<String, String> c1 = new Container<String, String>("name", "findingsea");
        Container<String, Integer> c2 = new Container<String, Integer>("age", 24);
        Container<Double, Double> c3 = new Container<Double, Double>(1.1, 2.2);
        System.out.println(c1.getKey() + " : " + c1.getValue());
        System.out.println(c2.getKey() + " : " + c2.getValue());
        System.out.println(c3.getKey() + " : " + c3.getValue());
	}
	
	static class Container<K, V> {
		private K key;
		private V value;

		public Container(K k, V v) {
			key = k;
			value = v;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}
}
